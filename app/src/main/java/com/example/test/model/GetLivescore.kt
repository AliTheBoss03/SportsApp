package com.example.test.model

import com.example.test.data.LiveMatchesData.LiveMatches
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException
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

            val apiResponse = gson.fromJson(responseBody, LiveMatches::class.java)
            // den mest væsenlige kode at gøre brug af for at hente data fra dataklasserne
            apiResponse.response.mapNotNull { it.goals.away.toString()}
        }
    }
}