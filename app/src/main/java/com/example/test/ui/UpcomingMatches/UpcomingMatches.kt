package com.example.test.ui.UpcomingMatches
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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.test.R

fun Row(modifier: Modifier, verticalArrangement: Arrangement.Vertical, any: Any?) {

}

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
fun SearchBar(onSearch: (String) -> Unit) {
    var searchText by remember { mutableStateOf("") }


    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
            onSearch(it)


        },
        placeholder = { Text("Search") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp,0.dp,10.dp,10.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(corner = CornerSize(20.dp))),



        )


}

@Composable
fun SearchFunktion() {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            
    ) {


        // Søgebjælke
        com.example.test.ui.results.SearchBar(onSearch = { query ->
            // Opdater logik baseret på søgeordet (query)
            searchQuery = query
            // F.eks. opdater søgeresultater eller udfør anden relevant logik
        })


    }
}

@Composable
fun MatchRow1(navController:NavController) {
    Column {


        Spacer(modifier = Modifier.height(100.dp)) // Tilføjer et mellemrum fra searhbar toppen

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
            navController.navigate("LineUp")
        },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically



        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.liverpool), // holdlogo
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
                    text = "09:00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "23 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D))


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.crystal), // Erstat med det korrekte holdlogo
                    contentDescription = "Team Two Logo",
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
fun MatchRow2(navController: NavController) {
    Column {

        Spacer(modifier = Modifier.height(170.dp)) // Tilføjer et mellemrum fra searhbar toppen

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
            navController.navigate("LineUp")
        },

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.liverpool), // holdlogo
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
                    text = "09:00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "23 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D))


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.crystal), // Erstat med det korrekte holdlogo
                    contentDescription = "Team Two Logo",
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
fun MatchRow3(navController: NavController) {
    Column {

        Spacer(modifier = Modifier.height(240.dp)) // Tilføjer et mellemrum fra searhbar toppen

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
                    navController.navigate("LineUp")
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.leeds), // holdlogo
                    contentDescription = "Team One Logo",
                    modifier = Modifier
                        .height(61.dp)
                        .width(61.dp)
                )
                Text(
                    text = "CHE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Kamp tid og dato
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "08:00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "28 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D))


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.chelsea), // Erstat med det korrekte holdlogo
                    contentDescription = "Team Two Logo",
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
fun MatchRow4(navController: NavController) {
    Column {

        Spacer(modifier = Modifier.height(310.dp)) // Tilføjer et mellemrum fra searhbar toppen

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
                    navController.navigate("LineUp")
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.chelsea), // holdlogo
                    contentDescription = "Team One Logo",
                    modifier = Modifier
                        .height(61.dp)
                        .width(61.dp)
                )
                Text(
                    text = "CHE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Kamp tid og dato
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "08:00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "28 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D))


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.mancity), // Erstat med det korrekte holdlogo
                    contentDescription = "Team Two Logo",
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
fun MatchRow5(navController: NavController) {
    Column {

        Spacer(modifier = Modifier.height(380.dp)) // Tilføjer et mellemrum fra searhbar toppen

        Row(
            modifier = Modifier
                .height(60.dp)
                // Brug fillMaxWidth for at undgå at hardkode bredden
                .fillMaxWidth()
                // Tilføj afrundede hjørner her
                .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
                .background(Color.White)
                .padding(9.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.brighton), // holdlogo
                    contentDescription = "Team One Logo",
                    modifier = Modifier
                        .height(61.dp)
                        .width(61.dp)
                )
                Text(
                    text = "CHE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Kamp tid og dato
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "08:00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "28 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D))


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.wat), // Erstat med det korrekte holdlogo
                    contentDescription = "Team Two Logo",
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
fun MatchRow6(navController: NavController) {
    Column {

        Spacer(modifier = Modifier.height(450.dp)) // Tilføjer et mellemrum fra searhbar toppen

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
                    navController.navigate("LineUp")
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.astonvilla), // holdlogo
                    contentDescription = "Team One Logo",
                    modifier = Modifier
                        .height(61.dp)
                        .width(61.dp)
                )
                Text(
                    text = "CHE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Kamp tid og dato
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "08:00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "28 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D))


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.everton), // Erstat med det korrekte holdlogo
                    contentDescription = "Team Two Logo",
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
fun MatchRow7(navController: NavController) {
    Column {

        Spacer(modifier = Modifier.height(520.dp)) // Tilføjer et mellemrum fra searhbar toppen

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
                    navController.navigate("LineUp")
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.mancity), // holdlogo
                    contentDescription = "Team One Logo",
                    modifier = Modifier
                        .height(61.dp)
                        .width(61.dp)
                )
                Text(
                    text = "CHE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Kamp tid og dato
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "08:00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "28 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D))


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.astonvilla), // Erstat med det korrekte holdlogo
                    contentDescription = "Team Two Logo",
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
fun MatchRow8(navController: NavController) {
    Column {

        Spacer(modifier = Modifier.height(590.dp)) // Tilføjer et mellemrum fra searhbar toppen

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
                    navController.navigate("LineUp")
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.liverpool), // holdlogo
                    contentDescription = "Team One Logo",
                    modifier = Modifier
                        .height(61.dp)
                        .width(61.dp)
                )
                Text(
                    text = "CHE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Kamp tid og dato
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "08:00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "28 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D))


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.leeds), // Erstat med det korrekte holdlogo
                    contentDescription = "Team Two Logo",
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
fun MatchRow9(navController: NavController) {
    Column {

        Spacer(modifier = Modifier.height(660.dp)) // Tilføjer et mellemrum fra searhbar toppen

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
                    navController.navigate("LineUp")
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.brighton), // holdlogo
                    contentDescription = "Team One Logo",
                    modifier = Modifier
                        .height(61.dp)
                        .width(61.dp)
                )
                Text(
                    text = "CHE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Kamp tid og dato
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "08:00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "28 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D))


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.astonvilla), // Erstat med det korrekte holdlogo
                    contentDescription = "Team Two Logo",
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
fun MatchRow10(navController: NavController) {
    Column {

        Spacer(modifier = Modifier.height(730.dp)) // Tilføjer et mellemrum fra searhbar toppen

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
                    navController.navigate("LineUp")
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Hold 1 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.mancity), // holdlogo
                    contentDescription = "Team One Logo",
                    modifier = Modifier
                        .height(61.dp)
                        .width(61.dp)
                )
                Text(
                    text = "CHE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Kamp tid og dato
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "08:00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Text(
                    text = "28 May",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xffE8791D))


            }

            // Hold 2 logo og navn
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.chelsea), // Erstat med det korrekte holdlogo
                    contentDescription = "Team Two Logo",
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
fun Upcoming(navController: NavHostController) {
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
    )

    {
        logo()
        SearchFunktion()
        MatchRow1(navController)
        MatchRow2(navController)
        MatchRow3(navController)
        MatchRow4(navController)
        MatchRow5(navController)
        MatchRow6(navController)
        MatchRow7(navController)
        MatchRow8(navController)
        MatchRow9(navController)
        MatchRow10(navController)
        }
    }

@Preview
@Composable
private fun PreviewUpcoming() {
    Upcoming(navController = rememberNavController())
}
