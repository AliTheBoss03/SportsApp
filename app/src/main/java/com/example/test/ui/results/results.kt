package com.example.test.ui.results


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.test.ViewModel.MyViewModel
import com.example.test.R

@Composable
fun logo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),


        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Image",
            modifier = Modifier
                .height(52.dp)
                .width(52.dp)

        )

    }

}
@Composable
fun SearchBar(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {
        Row (
            modifier = Modifier
                .width(125.dp)
                .height(31.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top

        ) {
            IconButton(onClick = { navController.navigate("news") }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_newspaper_24),
                    contentDescription = "Image",
                    modifier = Modifier
                        .height(22.dp)
                        .width(27.dp)
                )
            }

            IconButton(onClick = { navController.navigate("settings") }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_settings_24),
                    contentDescription = "Image",
                    modifier = Modifier
                        .height(22.dp)
                        .width(27.dp)
                )
            }
        }

    }
}
@Composable
fun PremBar(navController: NavController,viewModel: MyViewModel) {

    // Premierleague Bar
    val results by viewModel.resultData.collectAsState()
    LaunchedEffect(key1 = Unit,) {
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 75.dp),
        horizontalAlignment = Alignment.Start,
    ) {
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
                Text(text = "Premier League", color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = "England", color = Color.White)
            }
        }



        LazyColumn(){
            itemsIndexed(results?.response ?: arrayListOf()) { i , item ->
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
                            text = item.fixture.status.short.toString(),
                            color = androidx.compose.ui.graphics.Color.White,
                            textAlign = TextAlign.Right,
                            modifier =  Modifier

                                .fillMaxWidth()
                        )

                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 5.dp),
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

@Composable
fun ResultsView(navController: NavHostController, viewModel: MyViewModel) {

    // Anvender Column som den yderste container
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#FF9900"))
                        )
                    )
                )
        ) {
            logo()
            PremBar(navController,viewModel)
            SearchBar(navController)
        }

    }
}

