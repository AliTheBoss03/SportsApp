package com.example.test.ui.MatchView


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.test.ViewModel.MyViewModel
import com.example.test.R
import com.example.test.data.response.TeamRes


@Composable
fun logo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),


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

}


@Composable
fun searchBar(navController: NavController) {
    Column(
        modifier = Modifier
            .height(65.dp)
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {
        Row(
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
fun backButton() {

}


@Composable
fun Team(item: List<TeamRes.Response>) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp)
            .height(125.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        if(item.isNotEmpty()){
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically


            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = item.first().team.name,
                    color = androidx.compose.ui.graphics.Color.White,
                    textAlign = TextAlign.Start

                )


                //Logo for man utd
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.first().team.logo)
                        .crossfade(true)
                        .build(),
                    "",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .padding(start = 12.dp) // Juster afstanden efter behov

                )


                Spacer(modifier = Modifier.weight(1f))


                //Logo for man city
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.last().team.logo)
                        .crossfade(true)
                        .build(),
                    "",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .padding(end = 12.dp) // Juster afstanden efter behov
                )




                Text(
                    text = item.last().team.name,
                    color = androidx.compose.ui.graphics.Color.White,
                    textAlign = TextAlign.Right
                )


            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp), // Juster afstanden efter behov
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.first().formation,
                    color = androidx.compose.ui.graphics.Color.White,
                    textAlign = TextAlign.Center
                )

            }
        }


    }
}


@Composable
fun LineUP(navController: NavController,onNavigate:(String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
            .height(125.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 85.dp)
                .height(125.dp)
                .border(2.dp, Color.White),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Button(
                onClick = { onNavigate("lu") },
                modifier = Modifier
                    .padding(1.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(Color.Transparent),


                ) {
                Text(
                    text = "Line-Up",
                    color = androidx.compose.ui.graphics.Color.White,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold


                )


            }





            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(20.dp)
                    .background(androidx.compose.ui.graphics.Color.White)
            )



            Button(
                onClick = { onNavigate("ed") },
                modifier = Modifier
                    .padding(1.dp)
                    .weight(1.5f),
                colors = ButtonDefaults.buttonColors(Color.Transparent),


                ) {
                Text(
                    text = "Event Details",
                    modifier = Modifier,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )


            }





            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(20.dp)
                    .background(androidx.compose.ui.graphics.Color.White)


            )
        }

    }
}

@Composable
fun LineUpView(
    navController: NavController,
    fixId: String?,
    teamId: String?,
    viewModel: MyViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onNavigatePrediction:(String)->Unit
) {

    val data = viewModel.teamData.collectAsState()
    val euData = viewModel.fixtureData.collectAsState()
    var state by remember {
        mutableStateOf("lu")
    }

    LaunchedEffect(key1 = Unit) {
        Log.d("TAGTeam", "LineUpView3333: $fixId - $teamId")
        teamId?.let {
            viewModel.getTeam( teamId)
            viewModel.getFixture(it)
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#FF9900"))
                        )
                    )
                )
        ) {
            searchBar(navController)
            logo()

            OutlinedButton(
                onClick = { fixId?.let {
                    onNavigatePrediction(it)
                } },
                border = BorderStroke(1.dp, Color.White),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.TopCenter)
            ) {
                Text(text ="Predictions"
                    , modifier = Modifier, color = Color.White, fontSize = 15.sp)
            }


            when(state){
                "lu"->{
                    data.value?.response?.let {
                        if(it.isNotEmpty()){
                            Team(it)
                            LineUP(navController) {
                                state = it
                            }
                            //FootballField()
                            Row {
                                LazyColumn(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(top = 205.dp, start = 20.dp)
                                ) {
                                    item {
                                        Spacer(modifier = Modifier.height(78.dp))
                                    }
                                    itemsIndexed(
                                        it.first().startXI ?: arrayListOf()
                                    ) { i, item ->
                                        Text(
                                            text = item.player.name,
                                            color = androidx.compose.ui.graphics.Color.White,
                                            textAlign = TextAlign.Center

                                        )
                                    }
                                }
                                LazyColumn(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(top = 205.dp, start = 20.dp)
                                ) {
                                    item {
                                        Spacer(modifier = Modifier.height(78.dp))
                                    }
                                    itemsIndexed(
                                        it.last().startXI ?: arrayListOf()
                                    ) { i, item ->
                                        Text(
                                            text = item.player.name,
                                            color = androidx.compose.ui.graphics.Color.White,
                                            textAlign = TextAlign.Center

                                        )
                                    }
                                }
                            }
                        } else {
                            Toast.makeText(LocalContext.current, "List is empty", Toast.LENGTH_SHORT).show()
                        }

                    }
                }
                "ed"->{
                    euData.value?.response?.let {
                        LineUP(navController) {
                            state = it
                        }
                        Stadium(it.first().fixture.venue.city)
                        Ref(it.first().fixture.referee)
                    }
                }
            }


        }

    }
}


