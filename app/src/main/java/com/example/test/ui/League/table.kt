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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody.Companion.toResponseBody

@Composable
fun PremierLeagueHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
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



data class TeamStanding(
    val position: Int,
    val teamName: String,
    val matchesWon: Int,
    val matchesDrawn: Int,
    val matchesLost: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val points: Int
)
data class TopScorer(
    val position: Int,
    val playerName: String,
    val team: String,
    val goals: Int,
    val assists: Int
)

@Composable
fun LeagueTable(standings: List<TeamStanding>) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(8.dp)
    ) {
        // Overskrifter for kolonnerne
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "#", modifier = Modifier.weight(0.1f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "Team", modifier = Modifier.weight(1.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "M", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "W", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "D", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "L", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "G", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "PTS", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
        }

        // Holdstandinger
        LazyColumn {
            items(standings) { standing ->
                TeamStandingRow(standing)
            }
        }
    }
}

@Composable
fun TeamStandingRow(standing: TeamStanding) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .border(0.5.dp, Color(0xFFFFA500)),
        color = Color.Black
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "${standing.position}", modifier = Modifier.weight(0.1f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Row(
                modifier = Modifier.weight(1.5f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = getTeamLogo(standing.teamName)),
                    contentDescription = "${standing.teamName} Logo",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = standing.teamName, color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            }
            Text(text = "${standing.matchesWon}", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "${standing.matchesDrawn}", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "${standing.matchesLost}", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "${standing.goalsFor}:${standing.goalsAgainst}", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "${standing.points}", modifier = Modifier.weight(0.5f), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
        }
    }
}



fun getTeamLogo(teamName: String): Int {

    return when (teamName) {
        "Man City" -> R.drawable.mancity
        "Liverpool" -> R.drawable.liverpool
        "Chelsea" -> R.drawable.chelsea
        "Tottenham" -> R.drawable.tottenham
        "Arsenal" -> R.drawable.arsenal

        else -> R.drawable.logo
    }
}


@Composable
fun TopScorersList(topScorers: List<TopScorer>) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(8.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text("Top Scorers", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(0xFFFFA500))
        LazyColumn {
            items(topScorers) { scorer ->
                TopScorerRow(scorer)
            }
        }
    }
}

@Composable
fun TopScorerRow(scorer: TopScorer) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .border(0.5.dp, Color(0xFFFFA500)),
        color = Color.Black
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = scorer.position.toString(), color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = scorer.playerName, color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = scorer.team, color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "${scorer.goals} goals", color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
            Text(text = "${scorer.assists} assists", color = Color(0xFFFFA500), fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun PremierLeagueScreen(standings: List<TeamStanding>, topScorers: List<TopScorer>) {
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
            LeagueTable(standings = standings)
            Spacer(modifier = Modifier.height(16.dp))
            TopScorersList(topScorers = topScorers)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPremierLeagueScreen() {
    val leagueData = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
      //  leagueData.value = getLeagueData()
        println(leagueData.value)
    }

    // Display the league data or a loading message
    if (leagueData.value.isEmpty()) {
        Text("Loading...")
    } else {
        Text(leagueData.value)
    }

}
/**

//kopier nedståejde og sæt det ind i en anden klasse
private suspend fun getLeagueData(): String {
    return withContext(Dispatchers.IO) {
        try {
            val getLeague = GetLeague()
            val apiResponse = getLeague.CallGetLeague() ?: return@withContext "API response is null"

            apiResponse.toString()
        } catch (e: Exception) {
            // Håndter andre exception-tilfælde efter behov
            return@withContext "Error: ${e.message}"
        }
    }
}
*/


