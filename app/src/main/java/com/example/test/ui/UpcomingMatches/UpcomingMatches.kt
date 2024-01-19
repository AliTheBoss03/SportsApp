package com.example.test.ui.UpcomingMatches

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.test.ViewModel.MyViewModel
import com.example.test.R
import com.example.test.model.getDate
import com.example.test.model.getTime
import com.example.test.data.response.UpcommingRes

@Composable
fun logo() {
    Column(
        modifier = Modifier
            .height(52.dp)
            .width(52.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
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
fun SearchBar(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
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
fun MatchRow1(navController: NavController, item: UpcommingRes.Response) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .height(60.dp)
                // Brug fillMaxWidth for at undgå at hardkode bredden
                .fillMaxWidth()
                // Tilføj afrundede hjørner her
                .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
                .background(Color.White)
                .padding(9.dp)
                .clickable {
                    // Naviger til LineUp skærmen

                    Log.d(
                        "TAGTeam",
                        "LineUpView: ${item.fixture.id} - ${item.teams.home.id} ${item.fixture.venue.id}"
                    )
                    navController.navigate("LineUp/{${item.fixture.id}}/{${item.teams.home.id}}/{${item.fixture.venue.id}}")
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically


        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.teams.home.logo)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Team One Logo",
                    modifier = Modifier
                        .height(61.dp)
                        .width(61.dp)
                )
                Text(
                    text = "LFC",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Kamp tid og dato
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = getTime(item.fixture.timestamp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xFF311906)
                )

                Text(
                    text = getDate(item.fixture.timestamp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D)
                )


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.teams.away.logo)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Team One Logo",
                    modifier = Modifier
                        .height(61.dp)
                        .width(61.dp)
                )
                Text(
                    text = "WAT",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}
@Composable
fun Upcoming(navController: NavHostController, viewModel: MyViewModel) {
    val data = viewModel.upcomingData.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#FF9900"))
                        )
                    )
                )

        ) {
            logo()
            SearchBar(navController)
            LazyColumn() {
                item {
                    Spacer(modifier = Modifier.height(78.dp))
                }
                itemsIndexed(
                    data.value?.response ?: arrayListOf()
                ) { i, item ->
                    MatchRow1(navController, item)
                }
            }
        }
    }
}




