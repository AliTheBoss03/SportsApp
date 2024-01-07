package com.example.test

import retrofit2.Call
import retrofit2.http.GET

interface apiInterface {
    @GET( value = "api/v1/json/3/lookuptable.php?l=4328&s=2020-2021/")
    fun getData(): Call<List<Table>>
}
