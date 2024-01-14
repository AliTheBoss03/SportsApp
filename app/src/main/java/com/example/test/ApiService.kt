package com.example.test

import com.example.test.data.LiveMatchesData.LiveMatches

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
        @GET("v3/fixtures")
        suspend fun fetchData(): Response<LiveMatches>
}
