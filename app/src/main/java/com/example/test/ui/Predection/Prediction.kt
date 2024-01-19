package com.example.test.ui.Predection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.test.ViewModel.MyViewModel
import com.example.test.R
import com.example.test.data.response.PredictionRes



@Composable
fun Leaderboard(home:String,away:String,predictions: PredictionRes.Response.Predictions.Percent) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            "Leaderboard",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                home,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                "${predictions.home}%",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Draw",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                "${predictions.draw}%",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                away,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                "${predictions.away}%",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun SharePredictionButton(onShareClicked: () -> Unit) {
    Button(
        onClick = onShareClicked,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text("Share Prediction", color = MaterialTheme.colorScheme.onPrimary)
    }
}

// Implementer logik for at åbne delingsdialogen her.
fun onSharePrediction() {
    // ...
}

@Composable
fun MatchRow(teams: PredictionRes.Response.Teams) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(corner = CornerSize(12.dp)))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TeamInfo(teamName = teams.home.name, teamLogo = teams.home.logo)
            MatchTime(time = "VS", date = "-")
            TeamInfo(teamName = teams.away.name, teamLogo = teams.away.logo)
        }
    }
}

@Composable
fun TeamInfo(teamName: String, teamLogo: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(teamLogo)
                .crossfade(true)
                .build(),
            contentDescription = "$teamName Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = teamName,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun WinnerSelectionHeader() {
    Text(
        text = "Who will win?",
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(top = 16.dp, bottom = 8.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.White
    )
}

@Composable
fun WinnerSelectionRow(home:String, away: String,onSelection: (String) -> Unit) {
    Column {
        WinnerSelectionHeader()
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { onSelection("CHE") },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(home, color = MaterialTheme.colorScheme.onPrimary)
            }
            Button(
                onClick = { onSelection("DRAW") },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text("Draw", color = MaterialTheme.colorScheme.onTertiary)
            }
            Button(
                onClick = { onSelection("WAT") },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(away, color = MaterialTheme.colorScheme.onSecondary)
            }
        }
    }
}

@Composable
fun MatchTime(time: String, date: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = time,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        Text(
            text = date,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color(0xffE8791D)
        )
    }
}

@Composable
fun MatchScreen(fixId: String, viewModel: MyViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    LaunchedEffect(key1 = Unit,) {
        viewModel.getPredictions(fixId)
    }
    var isShow by remember {
        mutableStateOf(false)
    }
    val prediction by viewModel.predictionData.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF131313),
                        Color(0xFFFF9900)
                    )
                )
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .align(Alignment.TopStart)
        )

        prediction?.response?.let {
            Column {
                Spacer(modifier = Modifier.height(70.dp))
                MatchRow(it.first().teams)
                Spacer(modifier = Modifier.height(10.dp))
                WinnerSelectionRow(it.first().teams.home.name,it.first().teams.away.name,) { winner ->
                    isShow = true
                }
                if(isShow){
                    Leaderboard(it.first().teams.home.name,it.first().teams.away.name,it.first().predictions.percent)
                }
            }
        }
    }
}

