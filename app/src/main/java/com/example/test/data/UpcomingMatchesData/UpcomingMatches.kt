package com.example.test.data.UpcomingMatchesData

data class UpcomingMatches(
    val errors: List<Any>,
    val `get`: String,
    val paging: Paging,
    val parameters: Parameters,
    val response: List<Response>,
    val results: Int
)