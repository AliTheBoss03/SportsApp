package com.example.test.ui.news
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.R
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

data class NewsItem(
    val title: String,
    val imageResId: Int,
    val content: String
)

@Composable
fun logo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {

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
fun NewsScreen(navController: NavHostController, newsItems: List<NewsItem> = listOf(
    NewsItem("Officielt: David Nunez skriver under med Liverpool", R.drawable.nunez, "Her er indholdet af nyheden..."),
    NewsItem("Premier League Legende stopper karrieren", R.drawable.hazard, "Her er indholdet af nyheden..."),
    NewsItem("Chok skifte: Rasmus Højlund på vej væk?", R.drawable.rasmush, "Her er indholdet af nyheden...")
)) {
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
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                logo()
                searchBar(navController)
                Text(
                    text = "Scoreball News",
                    color = Color(0xFFFFA500),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 1.dp),
                    fontSize = 20.sp
                )
                Divider(
                    color = Color(0xFFFFA500),
                    thickness = 2.dp
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(newsItems) { news ->
                NewsArticle(news) {
                    navigateToNewsDetail(navController, news.title)
                }
            }

        }
    }
}

fun navigateToNewsDetail(navController: NavHostController, newsTitle: String) {
    navController.navigate("newsDetail/${newsTitle}")
}

@Composable
fun NewsArticle(news: NewsItem, onNewsClick: (NewsItem) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onNewsClick(news) } // Tilføj klik-håndtering her
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Column(modifier = Modifier.padding(all = 4.dp)) {
            Text(
                text = news.title,
                color = Color(0xFFFFA500),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))

            Image(
                painter = painterResource(id = news.imageResId),
                contentDescription = "Nyhedsbillede",
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Button(
                onClick = { /*...*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Læs Mere",
                    color = Color(0xFFFFA500) // For at beholde den orange farve på teksten
                )
            }
        }
    }
}


@Composable
fun searchBar(navController: NavController) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(15.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Row (
            modifier = Modifier
                .width(107.dp)
                .height(40.dp),
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
fun NewsScreenPreview(navController: NavController) {
    val dummyNavController = rememberNavController()
    NewsScreen(navController = dummyNavController, newsItems = listOf(
        NewsItem("Officielt: David Nunez skriver under med Liverpool", R.drawable.nunez, "Her er indholdet af nyheden..."),
        NewsItem("Premier League Legende stopper karrieren", R.drawable.hazard, "Her er indholdet af nyheden..."),
        NewsItem("Chok skifte: Rasmus Højlund på vej væk?", R.drawable.rasmush, "Her er indholdet af nyheden...")
    ))
}

@Preview
@Composable
fun prevNews() {
    NewsScreenPreview(navController = rememberNavController())
}