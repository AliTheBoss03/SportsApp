import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

data class StandingsResponse(
    val get: String,
    val parameters: StandingsParameters,
    val errors: List<StandingsErrors>,
    val results: Int,
    val paging: StandingsPaging,
    val response: Response
)

data class Response(
    @SerializedName("0")
    val league: League
)

data class League(
    val id: Int,
    val name: String,
    val country: String,
    val logo: String,
    val flag: String,
    val season: String,
    val standings: List<Standing>
)

data class StandingsParameters(
    val league: String,
    val season: String
)

data class StandingsErrors(
    val results: Int
)

data class StandingsPaging(
    val current: Int,
    val total: Int
)

data class Standing(
    val rank: Int,
    val team: Team,
    val points: Int,
    val goalsDiff: Int,
    val group: String,
    val form: String,
    val status: String,
    val description: String?,
    val all: StandingStats,
    val home: StandingStats,
    val away: StandingStats,
    val update: String
)

data class Team(
    val id: Int,
    val name: String,
    val country: String,
    val logo: String,
    val flag: String
)

data class StandingStats(
    val goalsDiff: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val wins: Int,
    val draws: Int,
    val loses: Int
)


class GetLeague {
    suspend fun CallGetLeague(): List<String> {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://api-football-v1.p.rapidapi.com/v3/leagues?id=39")
            .get()
            .addHeader("X-RapidAPI-Key", "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6")
            .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
            .build()

        return withContext(Dispatchers.IO) {
            val response = client.newCall(request).execute()

            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val responseBody = response.body!!.string()
            val gson = Gson()

            val standingsResponse = gson.fromJson(responseBody, StandingsResponse::class.java)

            standingsResponse.response.league.standings.map { it.team.name }
        }
    }
}


// api key: 6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6
//standingsResponse.standings.map { it.type }