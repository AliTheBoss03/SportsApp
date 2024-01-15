package com.example.test

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import apiService
import com.example.test.data.LiveMatchesData.LiveMatches
import kotlinx.coroutines.launch
import retrofit2.Response

class MyViewModel : ViewModel() {
    private val _data = mutableStateOf<LiveMatches?>(null)
    val data: State<LiveMatches?> = _data

    init {
        viewModelScope.launch {
            try {
                val response: Response<LiveMatches> = apiService.fetchData()

                if (response.isSuccessful) {
                    val liveMatches: LiveMatches? = response.body()
                    _data.value = liveMatches
                } else {
                    // Handle unsuccessful response (e.g., show an error message)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle exceptions (e.g., show an error message)
            }
        }
    }
}
