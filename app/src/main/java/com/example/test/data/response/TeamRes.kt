package com.example.test.data.response


import com.google.gson.annotations.SerializedName

data class TeamRes(

    @SerializedName("get")
    val `get`: String,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("parameters")
    val parameters: Parameters,
    @SerializedName("response")
    val response: List<Response>,
    @SerializedName("results")
    val results: Int
) {
    data class Paging(
        @SerializedName("current")
        val current: Int,
        @SerializedName("total")
        val total: Int
    )

    data class Parameters(
        @SerializedName("fixture")
        val fixture: String,
        @SerializedName("team")
        val team: String
    )

    data class Response(
        @SerializedName("coach")
        val coach: Coach,
        @SerializedName("formation")
        val formation: String,
        @SerializedName("startXI")
        val startXI: List<StartXI>,
        @SerializedName("substitutes")
        val substitutes: List<Substitute>,
        @SerializedName("team")
        val team: Team
    ) {
        data class Coach(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("photo")
            val photo: String
        )

        data class StartXI(
            @SerializedName("player")
            val player: Player
        ) {
            data class Player(
                @SerializedName("grid")
                val grid: String,
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("number")
                val number: Int,
                @SerializedName("pos")
                val pos: String
            )
        }

        data class Substitute(
            @SerializedName("player")
            val player: Player
        ) {
            data class Player(
                @SerializedName("grid")
                val grid: Any?,
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("number")
                val number: Int,
                @SerializedName("pos")
                val pos: String
            )
        }

        data class Team(
            @SerializedName("colors")
            val colors: Any?,
            @SerializedName("id")
            val id: Int,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("name")
            val name: String
        )
    }
}