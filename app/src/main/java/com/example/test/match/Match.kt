package com.example.test.match
import android.os.Parcel
import android.os.Parcelable

data class Match(
    val iD: String,
    val result: Int,
)


data class LiveMatchUpdate(
    val matchId: String?,
    val teams: Pair<String, String>,
    val score: Pair<Int, Int>,
    val events: List<MatchEvent>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        Pair(parcel.readString() ?: "", parcel.readString() ?: ""),
        Pair(parcel.readInt(), parcel.readInt()),
        mutableListOf<MatchEvent>().apply {
            parcel.readList(this, MatchEvent::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(matchId)
        parcel.writeString(teams.first)
        parcel.writeString(teams.second)
        parcel.writeInt(score.first)
        parcel.writeInt(score.second)
        parcel.writeTypedList(events)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<LiveMatchUpdate> {
        override fun createFromParcel(parcel: Parcel): LiveMatchUpdate = LiveMatchUpdate(parcel)
        override fun newArray(size: Int): Array<LiveMatchUpdate?> = arrayOfNulls(size)
    }
}

data class MatchEvent(
    val eventId: String,
    val type: MatchEventType,
    val time: String,
    val player: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        MatchEventType.values()[parcel.readInt()],
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(eventId)
        parcel.writeInt(type.ordinal)
        parcel.writeString(time)
        parcel.writeString(player)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<MatchEvent> {
        override fun createFromParcel(parcel: Parcel): MatchEvent = MatchEvent(parcel)
        override fun newArray(size: Int): Array<MatchEvent?> = arrayOfNulls(size)
    }
}

enum class MatchEventType {
    GOAL,
    RED_CARD,
    YELLOW_CARD,
    SUBSTITUTION
}

data class PlayerStatistics(
    val playerId: String,
    val playerName: String,
    val currentSeasonStats: SeasonStats
)

data class SeasonStats(
    val goals: Int,
    val assists: Int,
    val yellowCards: Int,
    val redCards: Int,
    val matchesPlayed: Int
)

data class FavoriteTeam(
    val teamId: String,
    val teamName: String,
    val isFavorite: Boolean
)

data class LeagueNewsUpdate(
    val newsId: String,
    val title: String,
    val content: String,
    val datePublished: String,
    val relatedTeam: String?
)