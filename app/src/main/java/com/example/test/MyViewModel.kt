package com.example.test.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.test.data.response.LeagueRes
import com.example.test.data.response.UpcommingRes
import com.example.test.data.response.LiveMatchRes
import com.example.test.data.response.PredictionRes
import com.example.test.data.response.TeamRes
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.Request

class MyViewModel : ViewModel() {
    private val _data = MutableStateFlow<LiveMatchRes?>(null)
    val data: StateFlow<LiveMatchRes?> = _data.asStateFlow()


    private val _resultData = MutableStateFlow<LiveMatchRes?>(null)
    val resultData: StateFlow<LiveMatchRes?> = _resultData.asStateFlow()

    private val _upcomingData = MutableStateFlow<UpcommingRes?>(null)
    val upcomingData: StateFlow<UpcommingRes?> = _upcomingData.asStateFlow()


    private val _leagueData = MutableStateFlow<LeagueRes?>(null)
    val leagueData: StateFlow<LeagueRes?> = _leagueData.asStateFlow()


    private val _teamData = MutableStateFlow<TeamRes?>(null)
    val teamData: StateFlow<TeamRes?> = _teamData.asStateFlow()


    private val _fixtureData = MutableStateFlow<LiveMatchRes?>(null)
    val fixtureData: StateFlow<LiveMatchRes?> = _fixtureData.asStateFlow()


    private val _predictionData = MutableStateFlow<PredictionRes?>(null)
    val predictionData: StateFlow<PredictionRes?> = _predictionData.asStateFlow()


    fun getLiveScore() {
        CoroutineScope(Dispatchers.IO).launch {
            _data.value = null
            val client = OkHttpClient()

            val request = Request.Builder()
                .url("https://api-football-v1.p.rapidapi.com/v3/fixtures?live=all")
                //URL for premier league live matches
                //.url("https://api-football-v1.p.rapidapi.com/v3/fixtures?live=all&league=39&season=2024")
                .get()
                .addHeader("X-RapidAPI-Key", "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6")
                .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                .build()

            val response = client.newCall(request).execute()

            if (response.isSuccessful) {
                val responseBody = response.body?.string()
                val fixtureResponse = Gson().fromJson(responseBody, LiveMatchRes::class.java)
                // Log.d("TAGApi", ":liveScoreResult ${fixtureResponse} ")
                _data.value = fixtureResponse
                println(fixtureResponse)
            } else {
                // Handle unsuccessful response
                println("Request failed with code: ${response.code}")
            }
        }
    }

    fun getResults() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val client = OkHttpClient()

                val request = Request.Builder()
                    .url("https://api-football-v1.p.rapidapi.com/v3/fixtures?league=39&season=2020")
                    .get()
                    .addHeader(
                        "X-RapidAPI-Key",
                        "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6"
                    )
                    .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .build()

                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    val responseBody = response.body?.string()
                    //Log.d("TAGApi", ":resultsBody ${responseBody} ")
                    val resultResponse = Gson().fromJson(responseBody, LiveMatchRes::class.java)
                    // Log.d("TAGApi", ":resultsRes ${resultResponse} ")
                    _resultData.value = resultResponse
                } else {
                    // Handle unsuccessful response
                    Log.d("TAGApi", ":resultsRes Error: ${response.code} ")
                }

            } catch (e: Exception) {
                Log.d("TAGApi", ":resultsRes ${e.message} ")
            }


        }
    }

    fun getUpcoming() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val client = OkHttpClient()

                val request = Request.Builder()
                    //URL to check the prediction implementation, could not work on premier league upcoming matches because of a mistake in the API used.
                    .url("https://api-football-v1.p.rapidapi.com/v3/fixtures?next=50")
                    //.url("https://api-football-v1.p.rapidapi.com/v3/fixtures?league=39&next=50")
                    .get()
                    .addHeader(
                        "X-RapidAPI-Key",
                        "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6"
                    )
                    .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .build()
                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    val responseBody = response.body?.string()
                    val fixtureResponse = Gson().fromJson(responseBody, UpcommingRes::class.java)
                    Log.d("TAGUpcoming", ":upcommint ${responseBody} ")
                    _upcomingData.value = fixtureResponse
                    println(fixtureResponse)
                } else {
                    // Handle unsuccessful response
                    println("Request failed with code: ${response.code}")
                }
            } catch (e: Exception) {
                Log.d("TAGApi", ":upcommingExRes ${e.message} ")
            }
        }
    }

    fun getLeague(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val client = OkHttpClient()

                val request = Request.Builder()
                    .url("https://api-football-v1.p.rapidapi.com/v3/standings?season=2023&league=39")
                    .get()
                    .addHeader(
                        "X-RapidAPI-Key",
                        "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6"
                    )
                    .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .build()

                val response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    val responseBody = response.body?.string()
                    val fixtureResponse = Gson().fromJson(responseBody, LeagueRes::class.java)
                    Log.d("TAGApi", ":leage ${fixtureResponse} ")
                    _leagueData.value = fixtureResponse
                    println(fixtureResponse)
                } else {
                    // Handle unsuccessful response
                    println("Request failed with code: ${response.code}")
                }

            } catch (e: Exception) {
                Log.d("TAGApi", ":upcommingExRes ${e.message} ")
            }
        }
    }


    fun getTeam(teamId: String){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val _fixId = 215662
                val _teamId = 463
                val id = teamId
                val client = OkHttpClient()

                // val url = "https://api-football-v1.p.rapidapi.com/v3/fixtures/lineups?fixture=$id"

                val innerContent = teamId.substring(1, teamId.length - 1)

                Log.d("TAGTeam", "getTeam: ${innerContent}")

                val baseUrl = "https://api-football-v1.p.rapidapi.com/v3/fixtures/lineups"
                val urlBuilder = baseUrl.toHttpUrlOrNull()?.newBuilder()

                // Add query parameters
                urlBuilder?.addQueryParameter("fixture", innerContent.toInt().toString())
                val url = urlBuilder?.build()

                val request = url?.let {
                    Request.Builder()
                        .url(it)
                        //.url("https://api-football-v1.p.rapidapi.com/v3/fixtures/lineups?fixture=215662")
                        .get()
                        .addHeader(
                            "X-RapidAPI-Key",
                            "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6"
                        )
                        .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                        .build()
                }

                val response = request?.let { client.newCall(it).execute() }

                if (response?.isSuccessful == true) {
                    val responseBody = response.body?.string()
                    val fixtureResponse = Gson().fromJson(responseBody, TeamRes::class.java)
                    Log.d("TAGApi", ":team ${responseBody} ")
                    _teamData.value = fixtureResponse
                    println(fixtureResponse)
                } else {
                    // Handle unsuccessful response
                    println("Request failed with code: ${response?.code}")
                }

            } catch (e: Exception) {
                Log.d("TAGApi", ":upcommingExResteam ${e.message} ")
            }
        }
    }

    fun getPredictions(fixId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {

                val client = OkHttpClient()
                val request = Request.Builder()
                    //.url("https://api-football-v1.p.rapidapi.com/v3/predictions?fixture=${fixId}")
                    .url("https://api-football-v1.p.rapidapi.com/v3/predictions?fixture=198772")
                    .get()
                    .addHeader(
                        "X-RapidAPI-Key",
                        "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6"
                    )
                    .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .build()

                val response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    val responseBody = response.body?.string()
                    val fixtureResponse = Gson().fromJson(responseBody, PredictionRes::class.java)
                    Log.d("TAGApi", ":team ${fixtureResponse} ")
                    _predictionData.value = fixtureResponse
                    println(fixtureResponse)
                } else {
                    // Handle unsuccessful response
                    println("Request failed with code: ${response.code}")
                }

            } catch (e: Exception) {
                Log.d("TAGApi", ":upcommingExRes ${e.message} ")
            }
        }
    }

    fun getFixture(teamId: String ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {

                val innerContent = teamId.substring(1, teamId.length - 1)

                val baseUrl = "https://api-football-v1.p.rapidapi.com/v3/fixtures"
                val urlBuilder = baseUrl.toHttpUrlOrNull()?.newBuilder()

                // Add query parameters
                urlBuilder?.addQueryParameter("id", innerContent.toInt().toString())
                val url = urlBuilder?.build()

                val client = OkHttpClient()
                val request = url?.let {
                    Request.Builder()
                        .url(it)
                        //.url("https://api-football-v1.p.rapidapi.com/v3/fixtures/lineups?fixture=215662")
                        .get()
                        .addHeader(
                            "X-RapidAPI-Key",
                            "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6"
                        )
                        .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                        .build()
                }

                val response = request?.let { client.newCall(it).execute() }


//                val request = Request.Builder()
//                    .url("https://api-football-v1.p.rapidapi.com/v3/predictions?fixture=${innerContent}")
//                    //.url("https://api-football-v1.p.rapidapi.com/v3/fixtures?id=215662")
//                    .get()
//                    .addHeader(
//                        "X-RapidAPI-Key",
//                        "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6"
//                    )
//                    .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
//                    .build()
//
//                val response = client.newCall(request).execute()

                if (response?.isSuccessful == true) {
                    val responseBody = response?.body?.string()
                    val fixtureResponse = Gson().fromJson(responseBody, LiveMatchRes::class.java)
                    Log.d("TAGApi", ":fixtt ${fixtureResponse} ")
                    _fixtureData.value = fixtureResponse
                    println(fixtureResponse)
                } else {
                    // Handle unsuccessful response
                    println("Request failed with code: ${response?.code}")
                }

            } catch (e: Exception) {
                Log.d("TAGApi", ":upcommingExRes ${e.message} ")
            }
        }
    }

}
