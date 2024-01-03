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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.R

data class Prediction(
    val userName: String,
    val prediction: String,
    val accuracy: Float
)

val dummyPredictions = listOf(
    Prediction(userName = "Chelsea", prediction = "Chelsea", accuracy = 70f),
    Prediction(userName = "Watford", prediction = "Uafgjort", accuracy = 10f),
    Prediction(userName = "Draw", prediction = "Watford", accuracy = 20f)

)

@Composable
fun Leaderboard(predictions: List<Prediction>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            "Leaderboard",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )
        predictions.sortedByDescending { it.accuracy }.take(5).forEach { prediction ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    prediction.userName,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    "${prediction.accuracy}%",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
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
fun MatchRow() {
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
            TeamInfo(teamName = "Chelsea", teamLogo = R.drawable.chelsea)
            MatchTime(time = "13:00", date = "28 May")
            TeamInfo(teamName = "Watford", teamLogo = R.drawable.wat)
        }
    }
}

@Composable
fun TeamInfo(teamName: String, teamLogo: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = teamLogo),
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
fun WinnerSelectionRow(onSelection: (String) -> Unit) {
    Column {
        WinnerSelectionHeader()
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { onSelection("CHE") },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(8.dp)
            ) {
                Text("Chelsea", color = MaterialTheme.colorScheme.onPrimary)
            }
            Button(
                onClick = { onSelection("DRAW") },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(8.dp)
            ) {
                Text("Draw", color = MaterialTheme.colorScheme.onTertiary)
            }
            Button(
                onClick = { onSelection("WAT") },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(8.dp)
            ) {
                Text("Watford", color = MaterialTheme.colorScheme.onSecondary)
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
fun MatchScreen() {
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

        Column {
            Spacer(modifier = Modifier.height(70.dp))
            MatchRow()
            Spacer(modifier = Modifier.height(10.dp))
            WinnerSelectionRow { winner ->
                // Implementer din logik her for at håndtere brugerens valg
            }
            Leaderboard(dummyPredictions)
            SharePredictionButton(onShareClicked = ::onSharePrediction)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PreviewMatchScreen() {
    MatchScreen()
}