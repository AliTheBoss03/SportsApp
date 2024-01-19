package com.example.test.model

import java.text.SimpleDateFormat
import java.util.Locale

fun getTime(timestamp: Long): String {



    val simpleDateFormat = SimpleDateFormat("HH:mm", Locale.ENGLISH)

    return simpleDateFormat.format(timestamp * 1000L)
}


fun getDate(date: Long): String {
    val simpleDateFormat = SimpleDateFormat("dd MM", Locale.ENGLISH)

    return simpleDateFormat.format(date * 1000L)
}