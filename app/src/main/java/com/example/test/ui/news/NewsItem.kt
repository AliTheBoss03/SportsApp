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
        horizontalAlignment = Alignment.Start){


        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(42.dp)
                .width(49.dp)
        )
    }
}

@Composable
fun NewsScreen(newsItems: List<NewsItem> = listOf(
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
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(16.dp)
        ) {
            logo() //
            searchBar()
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
                NewsArticle(news)
            }
        }
    }
}

@Composable
fun NewsArticle(news: NewsItem) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
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
                contentDescription = "Nyhedsbilleder",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop


            )
        }
    }

}

@Composable
fun searchBar() {
    Row (
        modifier = Modifier
            .fillMaxWidth() // Gør Row bredden til den maksimale bredde.
            .height(65.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.End // Placerer børnene i enden (højre side) af Row.
    ) {
        Row (
            modifier = Modifier
                .width(107.dp)
                .height(31.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top

        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_newspaper_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(22.dp)
                    .width(27.dp)
            )
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

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsScreen()
}