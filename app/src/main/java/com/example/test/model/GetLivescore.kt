package com.example.test.model

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

data class ApiResponse(
    val get: String,
    val parameters: Parameters,
    val errors: List<Any>,
    val results: Int,
    val paging: Paging,
    val response: List<FixtureResponse>
)

data class Parameters(
    val live: String,
    val league: String
)

data class Paging(
    val current: Int,
    val total: Int
)

data class FixtureResponse(
    val fixture: Fixture,
    val league: League,
    val teams: Teams,
    val goals: Goals,
    val score: Score,
    val events: List<Any>
)

data class Fixture(
    val id: Int,
    val referee: String?,
    val timezone: String,
    val date: String,
    val timestamp: Long,
    val periods: Periods,
    val venue: Venue,
    val status: Status
)

data class League(
    val id: Int,
    val name: String,
    val country: String,
    val logo: String,
    val flag: String,
    val season: Int,
    val round: String
)

data class Teams(
    val home: Team,
    val away: Team
)

data class Team(
    val id: Int,
    val name: String,
    val logo: String,
    val winner: Boolean?
)

data class Goals(
    val home: Int?,
    val away: Int?
)

data class Score(
    val halftime: ScoreDetail,
    val fulltime: ScoreDetail,
    val extratime: ScoreDetail?,
    val penalty: ScoreDetail?
)

data class ScoreDetail(
    val home: Int?,
    val away: Int?
)

data class Periods(
    val first: Long?,
    val second: Long?
)

data class Venue(
    val id: Int?,
    val name: String,
    val city: String
)

data class Status(
    val long: String,
    val short: String,
    val elapsed: Int
)

class GetLivescore {
    suspend fun CallGetLivescore(): List<String> {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://api-football-v1.p.rapidapi.com/v3/fixtures?live=all&league=39")
            .get()
            .addHeader("X-RapidAPI-Key", "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6")
            .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
            .build()

        return withContext(Dispatchers.IO) {
            val response = client.newCall(request).execute()

            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val responseBody = response.body!!.string()
            val gson = Gson()

            val apiResponse = gson.fromJson(responseBody, ApiResponse::class.java)
            // den mest væsenlige kode at gøre brug af for at hente data fra dataklasserne
            apiResponse.response.mapNotNull { it.goals.away.toString()}
        }
    }
}