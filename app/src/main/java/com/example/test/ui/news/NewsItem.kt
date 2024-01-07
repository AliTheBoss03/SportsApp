package com.example.test.ui.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.R
import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


data class NewsItem(
    val title: String,
    val imageResId: Int
)
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
fun NewsScreen(navController: NavHostController, newsItems: List<NewsItem> = listOf(
    NewsItem("Officielt: David Nunez skriver under med Liverpool", R.drawable.nunez),
    NewsItem("Premier League Legende stopper karrieren", R.drawable.hazard),
    NewsItem("Chok skifte: Rasmus Højlund på vej væk?", R.drawable.rasmush)
)) {
    Column(
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(16.dp)
        ) {
            logo()
            searchBar(navController)
            Text(
                text = "Scoreball news",
                color = Color(0xFFFFA500),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 20.sp
            )
            Divider(
                color = Color(0xFFFFA500),
                thickness = 2.dp
            )
            Spacer(modifier = Modifier.height(16.dp))
            newsItems.forEach { news ->
                NewsArticle(news) {
                    // Når en nyhedsartikel klikkes, naviger til detaljesiden
                    navController.navigate("nyhedDetail/${news .title}")
                }
            }
        }
    }
}


@Composable
fun NewsArticle(news: NewsItem, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Text(
                text = news.title,
                color = Color(0xFFFFA500),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = news.imageResId),
                contentDescription = "Nyhedsbillede",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

        }

    }
}



@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    val dummyNavController = rememberNavController()  // Opretter en dummy NavController
    NewsScreen(navController = dummyNavController, newsItems = listOf(
        NewsItem("Eksempel nyhed 1", R.drawable.nunez),
        NewsItem("Eksempel nyhed 2", R.drawable.hazard),
        NewsItem("Eksempel nyhed 3", R.drawable.rasmush)
    ))

}