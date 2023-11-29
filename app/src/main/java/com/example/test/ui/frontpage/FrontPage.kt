package com.example.test.ui.frontpage

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
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
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
import com.example.test.R
import com.example.test.ui.news.NewsScreenPreview
import com.example.test.ui.results.previewResults
import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.test.Navigation
import com.example.test.ui.news.NewsItem


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
fun searchBar(navController: NavController) {
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
                .width(107.dp)
                .height(31.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#FF9900")),
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#FF9900"))
                        )
                    )
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
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




            Image(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(22.dp)
                    .width(27.dp)
            )
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
@Composable
fun newsBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
            .padding(vertical = 59.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        Row (
            modifier = Modifier
                .width(107.dp)
                .height(31.dp)

                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#FF9900")),
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#FF9900"))
                        )
                    )
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_right_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(22.dp)
                    .width(27.dp)
            )

            Text(text ="News"
                , modifier = Modifier, color = Color.White, fontSize = 10.sp)

            Image(
                painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(22.dp)
                    .width(27.dp)
            )
        }
        Image(painter = painterResource(id = R.drawable.nunez),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(115.dp),
            alignment = Alignment.Center
        )

        Text(text = "Officielt: Darwin Nunez skifter til Liverpool", modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(android.graphics.Color.parseColor("#FF9900")),
                        Color(android.graphics.Color.parseColor("#000000")),
                        Color(android.graphics.Color.parseColor("#FF9900"))
                    )
                )
            )
            .fillMaxWidth()
            , color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun LiveBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 275.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        Row(
            modifier = Modifier
                .width(107.dp)
                .height(31.dp)

                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#FF9900")),
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#FF9900"))
                        )
                    )
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_right_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(22.dp)
                    .width(27.dp)
            )

            Text(
                text = "Watch Live Now", modifier = Modifier, color = Color.White, fontSize = 7.sp
            )

            Image(
                painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(22.dp)
                    .width(27.dp)
            )

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
                .height(76.dp),
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
fun Results() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 190.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom


    ) {
        Row(
            modifier = Modifier
                .width(107.dp)
                .height(31.dp)

                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#FF9900")),
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#FF9900"))
                        )
                    )
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_right_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(22.dp)
                    .width(27.dp)
            )

            Text(
                text = "Results", modifier = Modifier, color = Color.White, fontSize = 10.sp
            )

            Image(
                painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(22.dp)
                    .width(27.dp)
            )

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
                .height(76.dp),
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


@Preview
@Composable
fun previewFrontpage() {
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
        searchBar(rememberNavController())
        newsBar()
        LiveBar()
        Results()
    }
}



