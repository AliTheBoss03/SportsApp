import com.example.test.data.LeagueStandingsData.LeagueData
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

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

            val standingsResponse = gson.fromJson(responseBody, LeagueData::class.java)
            //val teamNames = standingsResponse.response.getOrNull(1)?.league?.standings?.getOrNull(4)?.team?.name

            standingsResponse.response[2].league.standings.map { it[2].team.name }
        }
    }
}




// api key: 6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6
//standingsResponse.standings.map { it.type }