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
                text = "Eden Hazard takker alle sine fans, der har støttet ham, uanset hvor han har spillet.\n" +
                        "\n" +
                        "32-årige Eden Hazard har sat fodboldstøvlerne på hylden.\n" +
                        "\n" +
                        "Den tidligere Chelsea- og Real Madrid-stjerne har nemlig valgt at indstille sin karriere.\n" +
                        "\n" +
                        "- Du skal lytte til dig selv og sige stop på det rigtige tidspunkt. Efter 16 år og mere end 700 kampe har jeg besluttet at stoppe min karriere som professionel fodboldspiller, skriver Hazard på Instagram.ffensivspilleren var på toppen af karrieren, da han i 2019 kom til Real Madrid fra Chelsea, men har slet ikke haft samme succes som i London-klubben.\n" +
                        "\n" +
                        "På grund af skader og manglende form er det kun blevet 76 kampe og 7 mål fordelt på fire sæsoner, hvor han stort set aldrig har været stamspiller.",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsDetailScreenPreview() {
    NewsDetailScreen(NewsItem("Eden Hazard stopper karrieren ", R.drawable.hazard))

}
