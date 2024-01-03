package com.example.test.ui.favourite


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
import androidx.compose.material3.Divider
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
fun FavouriteMatches() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 65.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {

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
                Image(painter = painterResource(id = R.drawable.sharp_star_24), contentDescription = "favourite icon",
                    Modifier.padding(end = 270.dp))
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
        Divider(
            Modifier.padding(vertical = 20.dp),
            color = Color(0xFFFFA500),
            thickness = 1.dp
        )
    }
}


@Composable
fun Favourite(navController: NavController) {
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
        searchBar(navController)
        FavouriteMatches()
    }
}
@Preview
@Composable
private fun Preview() {
    Favourite(navController = rememberNavController())
}