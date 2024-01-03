package com.example.test.ui.frontpage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.test.R


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
fun SearchBar(navController: NavController) {
    Column(
        modifier = Modifier
            .height(65.dp)
            .fillMaxWidth()
            .padding(16.dp),
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

            IconButton(onClick = { navController.navigate("search") }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_search_24),
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
            .height(350.dp)
            .padding(vertical = 59.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        Row (
            modifier = Modifier
                .width(125.dp)
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
        Image(painter = painterResource(id = R.drawable.nunez),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(115.dp),
            alignment = Alignment.Center
        )

        Text(text = "Officielt: Darwin Nunez skifter til Liverpool", modifier = Modifier
            /**.background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(android.graphics.Color.parseColor("#FF9900")),
                        Color(android.graphics.Color.parseColor("#000000")),
                        Color(android.graphics.Color.parseColor("#FF9900"))
                    )
                )
            )*/
            .fillMaxWidth()
            , color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}




@Composable
fun LiveBar(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 250.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
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

            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
                    .height(38.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Chelsea"
                    , color = Color.White
                    , textAlign = TextAlign.Start)
                Text(text = "1"
                    , color = Color.White
                    , textAlign = TextAlign.Right)
            }
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(38.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Crystal Palace"
                    , color = Color.White
                )
                Text(text = "1"
                    , color = Color.White
                    , textAlign = TextAlign.Right)
            }
        }
    }
}

@Composable
fun Results(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 120.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom


    ) {
        Row(
            modifier = Modifier
                .width(125.dp)
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

            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
                    .height(38.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Chelsea"
                    , color = Color.White
                    , textAlign = TextAlign.Start)
                Text(text = "1"
                    , color = Color.White
                    , textAlign = TextAlign.Right)
            }
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(38.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Crystal Palace"
                    , color = Color.White
                )
                Text(text = "1"
                    , color = Color.White
                    , textAlign = TextAlign.Right)
            }
        }
    }
}



@Composable
fun FrontPage(navController: NavController) {
    Box(modifier = Modifier
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

        logo()
        SearchBar(navController)
        NewsBar(navController)
        LiveBar(navController)
        Results(navController)
    }
}

@Preview
@Composable
private fun Preview() {
    FrontPage(navController = rememberNavController())
}


