package com.example.test.data.LeagueStandingsData

import com.example.test.data.LeagueStandingsData.Goals

data class Home(
    val draw: Int,
    val goals: Goals,
    val lose: Int,
    val played: Int,
    val win: Int
)