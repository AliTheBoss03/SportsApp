package com.example.test.ui.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Surface
import com.example.test.R


data class NewsItem(
    val title: String,
    val imageUrl: String
)

@Composable
fun NewsScreen(newsItems: List<NewsItem> = listOf(
    NewsItem("Officielt: David Nunez skriver under med Liverpool", "image_url_1"),
    NewsItem("Premier League Legende stopper karrieren", "image_url_2"),
    NewsItem("Chok skifte: Rasmus Højlund på vej væk?", "image_url_3")
)) {
    Surface(
        Modifier.fillMaxSize(), color = Color.Black
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Football news",
                color = Color(0xFFFFA500),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
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
            containerColor = Color(0xFFFFA500)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Text(
                text = news.title,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = R.drawable.hazard),
                contentDescription = "Nyhedsbillede",
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsScreen()
}
