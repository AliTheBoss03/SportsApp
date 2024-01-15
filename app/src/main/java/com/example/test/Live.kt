package com.example.test


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.test.MyViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MyScreen(viewModel: MyViewModel = viewModel()) {
    val liveMatches by viewModel.data

    liveMatches?.let {
        Text("Country: ${it.response.first().league.country}")
        Text("Number of matches: ${it.results}")
    }
}
@Preview
@Composable
fun prevMyScreen(){
    MyScreen()
}