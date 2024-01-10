import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.test.R
import com.example.test.ui.news.NewsItem



data class NewsContent(
    val title: String,
    val content: String
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailScreen(newsItem: NewsItem) {
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
        SmallTopAppBar(
            title = {
                Text(
                    text = "Scoreball News Detail",
                    color = Color(0xFFFFA500),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Black,
                titleContentColor = Color(0xFFFFA500)
            )
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = newsItem.title,
                color = Color(0xFFFFA500),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = newsItem.imageResId),
                contentDescription = "Nyhedsbillede",
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = newsItem.content
                ,// Antager, at 'content' er en del af NewsItem
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsDetailScreenPreview() {

    NewsDetailScreen(NewsItem("Eden Hazard stopper karrieren ", R.drawable.hazard, "Her er indholdet af nyheden..."))
}

fun NewsItem(title: String, imageResId: Int, s: String): NewsItem {
    TODO("Not yet implemented")
}