package com.example.test.ui.frontpage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Divider
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
import com.example.test.data.response.LiveMatchRes


@Composable
fun logo() {
    Column(
        modifier = Modifier
            .padding(bottom = 20.dp),
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
fun NewsBar(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        Row (
            modifier = Modifier
                .width(125.dp)
                .height(35.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){
            OutlinedButton(
                onClick = { navController.navigate("news") },
                border = BorderStroke(1.dp, Color.White),
                modifier = Modifier.padding(1.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_newspaper_24),
                    contentDescription = "news",
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text ="News"
                    , modifier = Modifier, color = Color.White, fontSize = 15.sp)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Image(painter = painterResource(id = R.drawable.nunez),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(115.dp),
            alignment = Alignment.Center
        )

        Text(text = "Officielt: Darwin Nunez skifter til Liverpool", modifier = Modifier
            .fillMaxWidth()
            , color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}




@Composable
fun LiveBar(navController: NavController, item: LiveMatchRes.Response) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start


    ) {

        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Black)){
            Image(painter = painterResource(id = R.drawable.england),
                contentDescription = "image",
                Modifier
                    .padding(all = 20.dp)
                    .width(25.dp)
                    .height(20.dp))

            Column(modifier = Modifier
                .padding(top = 10.dp)
                .padding(end = 10.dp) ){
                Text(text ="Premier League", color = Color.White, fontWeight = FontWeight(800) )
                Text(text = "England", color = Color.White )
            }
        }
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
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
                    .padding(horizontal = 10.dp)
                    .padding(bottom = 20.dp),
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
        Divider(color = Color.Black, thickness = 1.dp)

    }
}

@Composable
fun Results(navController: NavController, item: LiveMatchRes.Response) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom


    ) {
        Row(
            modifier = Modifier
                .width(125.dp)
                .height(35.dp)
                .padding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            OutlinedButton(
                onClick = { navController.navigate("results") },
                border = BorderStroke(1.dp, Color.White),
                modifier = Modifier.padding(1.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "news",
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text ="Results"
                    , modifier = Modifier, color = Color.White, fontSize = 15.sp)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Black)){
            Image(painter = painterResource(id = R.drawable.england),
                contentDescription = "image",
                Modifier
                    .padding(all = 20.dp)
                    .width(25.dp)
                    .height(20.dp))

            Column(modifier = Modifier
                .padding(top = 10.dp)
                .padding(end = 10.dp) ){
                Text(text ="Premier League", color = Color.White, fontWeight = FontWeight(800) )
                Text(text = "England", color = Color.White )
            }
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
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
                    text = item.fixture.status.short,
                    color = androidx.compose.ui.graphics.Color.White,
                    textAlign = TextAlign.Right,
                    modifier =  Modifier
                        .fillMaxWidth()
                )

            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.teams.away.name.toString(), color = androidx.compose.ui.graphics.Color.White
                )
                Text(
                    text = item.goals.away.toString(),
                    color = Color.White,
                    textAlign = TextAlign.Right
                )
            }
        }
        Divider(color = Color.Black, thickness = 1.dp)
    }
}



@Composable
fun FrontPage(navController: NavController,viewModel: MyViewModel) {
    val liveMatches by viewModel.data.collectAsState()
    val resultData by viewModel.resultData.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(android.graphics.Color.parseColor("#000000")),
                    Color(android.graphics.Color.parseColor("#FF9900"))
                )
            )
        )
    ) {

        Row {
            logo()
            SearchBar(navController)
        }
        Row(
            modifier = Modifier
                .width(200.dp)
                .height(35.dp)
            /**
            .background(
            brush = Brush.verticalGradient(
            colors = listOf(
            Color(android.graphics.Color.parseColor("#FF9900")),
            Color(android.graphics.Color.parseColor("#000000")),
            Color(android.graphics.Color.parseColor("#FF9900"))
            )
            )
            )*/,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            OutlinedButton(
                onClick = { navController.navigate("livescreen") },
                border = BorderStroke(1.dp, Color.White),
                modifier = Modifier.padding(1.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_newspaper_24),
                    contentDescription = "news",
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text ="Watch Live Now"
                    , modifier = Modifier, color = Color.White, fontSize = 15.sp)
            }

        }
        liveMatches?.response?.let {
            if(it.isNotEmpty()){
                LiveBar(navController,it.first())
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        resultData?.response?.let {
            if(it.isNotEmpty()){
                Results(navController,it.first())
            }

        }
        Spacer(modifier = Modifier.height(15.dp))
        NewsBar(navController)

    }
}




