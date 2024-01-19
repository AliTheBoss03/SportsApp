package com.example.test.ui.Livescreen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column

import androidx.compose.runtime.*

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test.ViewModel.MyViewModel
import com.example.test.R


@Composable
fun prevMyScreen(navController: NavController, viewModel: MyViewModel) {
    LaunchedEffect(key1 = Unit,) {
    }
    val liveMatches by viewModel.data.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(75.dp)
            .padding()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(android.graphics.Color.parseColor("#000000")),
                        Color(android.graphics.Color.parseColor("#FF9900"))
                    )
                )
            )
        ,

        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,


        ) {

        Column(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Image",
                modifier = Modifier
                    .height(52.dp)
                    .width(52.dp)

            )

        }
        OutlinedButton(
            onClick = {
                viewModel.getLiveScore()
            },

            border = BorderStroke(1.dp, Color.White),
            modifier = Modifier
                .padding(start = 260.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_cached_24),
                contentDescription = "refresh",
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(text ="Refresh"
                , modifier = Modifier, color = Color.White, fontSize = 15.sp)
        }

        //England bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#000000"))
                        )
                    )
                ),
        )
        {

            Image(
                painter = painterResource(id = R.drawable.england),
                contentDescription = "image",
                Modifier
                    .padding(all = 20.dp)
                    .width(25.dp)
                    .height(20.dp)
            )

            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(end = 10.dp)
            ) {
                Text(
                    text = "Premier League",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "England", color = Color.White)
            }
        }

        liveMatches?.response?.let {
            if(it.isEmpty()){
                Text(text = "No matches available", color = androidx.compose.ui.graphics.Color.White)
            } else {
                LazyColumn(){
                    itemsIndexed(liveMatches?.response ?: arrayListOf()) { i , item ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, Color.Black),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp, vertical = 5.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(horizontalArrangement = Arrangement.Start) {
                                    Text(
                                        text = item.teams.home.name.toString(),
                                        color = androidx.compose.ui.graphics.Color.White,
                                        textAlign = TextAlign.Start
                                    )

                                }
                                Text(
                                    text = item.goals.home.toString(),
                                    color = androidx.compose.ui.graphics.Color.White,
                                    textAlign = TextAlign.Right
                                )

                            }

                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(end = 40.dp)
                            ) {
                                Text(
                                    text = item.fixture.status.elapsed.toString(),
                                    color = androidx.compose.ui.graphics.Color.White,
                                    textAlign = TextAlign.Right,
                                    modifier =  Modifier
                                        .fillMaxWidth()
                                )

                            }
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp,vertical = 5.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = item.teams.away.name.toString(), color = androidx.compose.ui.graphics.Color.White
                                )
                                Text(
                                    text = item.goals.away.toString(),
                                    color = androidx.compose.ui.graphics.Color.White,
                                    textAlign = TextAlign.Right
                                )
                            }

                        }
                    }

                }
            }

        }




    }


}