package com.example.test.ui.League


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.test.ViewModel.MyViewModel
import com.example.test.R
import com.example.test.data.response.LeagueRes

@Composable
fun PremierLeagueHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.pl),
            contentDescription = "Premier League Logo",
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            "Premier League England",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFFFFA500)
        )
    }
}

@Composable
fun LeagueTable(first: LeagueRes.Response) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding (bottom = 70.dp)
    ) {
        // Overskrifter for kolonnerne
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "#",
                modifier = Modifier.weight(0.1f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Team",
                modifier = Modifier.weight(1.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "W",
                modifier = Modifier.weight(0.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "D",
                modifier = Modifier.weight(0.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "L",
                modifier = Modifier.weight(0.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "G",
                modifier = Modifier.weight(0.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "PTS",
                modifier = Modifier.weight(0.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
        }

        // Holdstandinger
        LazyColumn {
            itemsIndexed(first.league?.standings?.first() ?: arrayListOf()) { i, item ->
                TeamStandingRow(i, item)
            }
        }
    }
}

@Composable
fun TeamStandingRow(i: Int, standing: LeagueRes.Response.League.Standing) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
            .border(0.5.dp, Color(0xFFFFA500)),
        color = Color.Black,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.weight(1.5f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${i+1}",
                    modifier = Modifier.weight(0.1f),
                    color = Color(0xFFFFA500),
                    fontWeight = FontWeight.Bold
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(standing.team.logo)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Logo",
                    modifier = Modifier.size(34.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    modifier = Modifier.weight(0.5f),
                    text = standing.team.name,
                    color = Color(0xFFFFA500),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
            Text(
                text = "${standing.all.win}",
                modifier = Modifier.weight(0.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${standing.all.draw}",
                modifier = Modifier.weight(0.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${standing.all.lose}",
                modifier = Modifier.weight(0.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${standing.goalsDiff}",
                modifier = Modifier.weight(0.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${standing.points}",
                modifier = Modifier.weight(0.5f),
                color = Color(0xFFFFA500),
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Composable
fun PremierLeagueScreen(value: LeagueRes?) {
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
        Column(modifier = Modifier.fillMaxSize()) {
            PremierLeagueHeader() // Dette vil vise Premier League-logoet og titlen
            Spacer(modifier = Modifier.height(32.dp)) // Juster denne værdi efter behov for at skabe nok plads
            value?.response?.first()?.let { LeagueTable(it) }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPremierLeagueScreen(viewModel: MyViewModel = viewModel()) {

    val data = viewModel.leagueData.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getLeague()
    }

    val leagueData = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        //  leagueData.value = getLeagueData()
        println(leagueData.value)
    }
    PremierLeagueScreen(data.value)

}


