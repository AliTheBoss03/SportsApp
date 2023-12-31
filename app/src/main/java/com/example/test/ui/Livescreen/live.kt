package com.example.test.ui.Livescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.test.R

class live {

}


@Composable
fun logo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),


        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Image",
            modifier = Modifier
                .height(52.dp)
                .width(52.dp)

        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
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
            .padding(50.dp, 0.dp, 10.dp, 10.dp)
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
            .height(100.dp)

    ) {


        // Søgebjælke
        SearchBar(onSearch = { query ->
            // Opdater logik baseret på søgeordet (query)
            searchQuery = query
            // F.eks. opdater søgeresultater eller udfør anden relevant logik
        })


    }
}





@Composable
fun kalender() {
    LazyRow(
        content = {
            items(5) { index ->
                val text = when (index) {
                    0 -> "  Sat 30"
                    1 -> "  Sun 31"
                    2 -> "  Mon 1"
                    3 -> "  Thu 2"
                    4 -> "  Wed 3"

                    else -> ""
                }
                kalenderLaylout(text,80.dp)


            }
        }
    )
}

@Composable
fun kalenderLaylout(text: String, paddingTop: Dp) {
    Box(
        modifier= Modifier
            .padding(16.5.dp)
            .padding(top = paddingTop)


    ){
        Row(
            modifier = Modifier
                .height(65.dp)
                .width(45.dp)
                .clip(RoundedCornerShape(corner = CornerSize(20.dp)))
                .background(

                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#FFA500")),
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#FFA500"))
                        )
                    )
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text= text,color= androidx.compose.ui.graphics.Color.White,
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold)

            )


        }


    }

}





@Composable
fun PremBar(navController: NavController) {
    // Premierleague Bar
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(75.dp)
            .padding(top = 175.dp),

        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,



        ) {


        //England bar
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(android.graphics.Color.parseColor("#000000")),
                        Color(android.graphics.Color.parseColor("#000000")),
                        Color(android.graphics.Color.parseColor("#000000"))
                    )
                )
            ),
        )


        {

            Image(painter = painterResource(id = R.drawable.england),
                contentDescription = "image",
                Modifier
                    .padding(all = 20.dp)
                    .width(25.dp)
                    .height(20.dp))

            Column(modifier = Modifier
                .padding(top = 10.dp)
                .padding(end = 10.dp) ){
                Text(text ="Premier League", color = androidx.compose.ui.graphics.Color.White, fontWeight = FontWeight.Bold )
                Text(text = "England", color = androidx.compose.ui.graphics.Color.White )
            }
        }


        //Resultater af Man UTD
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .border(1.dp, androidx.compose.ui.graphics.Color.Black)
                .clickable {
                    // Naviger til LineUp skærmen
                    navController.navigate("LineUp")
                },
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
                    .height(30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row (horizontalArrangement = Arrangement.Start) {
                    Text(text = "Manchester United"
                        , color = androidx.compose.ui.graphics.Color.White
                        , textAlign = TextAlign.Start)


                    Spacer(modifier = Modifier.width(180.dp))


                    Column {
                        Spacer(modifier = Modifier.height(11.dp)) // Move FT text slightly down
                        Text(text = "79'"
                            , color = androidx.compose.ui.graphics.Color.White
                            , textAlign = TextAlign.Start)
                    }


                }
                Text(text = "1"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Right)

            }


            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(35.dp),
                horizontalArrangement = Arrangement.SpaceBetween



            ){
                Text(text = "Luton City"
                    , color = androidx.compose.ui.graphics.Color.White
                )
                Text(text = "1"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Right)
            }

        }

        //Mellemrum for plads
        Row (
            Modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
                .height(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){



        }

        //Bunrley
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .border(1.dp, androidx.compose.ui.graphics.Color.Black)
                .clickable {
                    navController.navigate("LineUp")
                },

            verticalArrangement = Arrangement.SpaceBetween
        ){

            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
                    .height(30.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Burnley"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Start)
                Spacer(modifier = Modifier.width(200.dp))


                Column {
                    Spacer(modifier = Modifier.height(10.dp)) // Move FT text slightly down
                    Text(text = "12'"
                        , color = androidx.compose.ui.graphics.Color.White
                        , textAlign = TextAlign.Start)
                }



                Text(text = "1"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Right)


            }
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(38.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Arsenal"
                    , color = androidx.compose.ui.graphics.Color.White
                )
                Text(text = "3"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Right)
            }
        }


        //Mellemrum for plads
        Row (
            Modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
                .height(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
        }



        //Tottenham
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .border(1.dp, androidx.compose.ui.graphics.Color.Black)
                .clickable {
                    navController.navigate("LineUp")
                },
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
                    .height(30.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Tottenham"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Start)
                Spacer(modifier = Modifier.width(180.dp))


                Column {
                    Spacer(modifier = Modifier.height(10.dp)) // Move FT text slightly down
                    Text(text = "54'"
                        , color = androidx.compose.ui.graphics.Color.White
                        , textAlign = TextAlign.Start)
                }



                Text(text = "5"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Right)
            }
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(38.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Chealsea"
                    , color = androidx.compose.ui.graphics.Color.White
                )
                Text(text = "0"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Right)
            }
        }


        //Mellemrum for plads
        Row(
            Modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
                .height(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
        }



        //Westham
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .border(1.dp, androidx.compose.ui.graphics.Color.Black)
                .clickable {
                    navController.navigate("LineUp")
                },
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
                    .height(30.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Westham"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Start)
                Spacer(modifier = Modifier.width(185.dp))

                Column {
                    Spacer(modifier = Modifier.height(10.dp)) // Move FT text slightly down
                    Text(text = "65'"
                        , color = androidx.compose.ui.graphics.Color.White
                        , textAlign = TextAlign.Start)
                }



                Text(text = "3"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Right)
            }
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(38.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Nottingham"
                    , color = androidx.compose.ui.graphics.Color.White
                )
                Text(text = "2"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Right)


            }
        }

        //Mellem
        Row(
            Modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
                .height(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
        }


        //Brigthon
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .border(1.dp, androidx.compose.ui.graphics.Color.Black)
                .clickable {
                    navController.navigate("LineUp")
                },
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
                    .height(30.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Brigthon"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Start)
                Spacer(modifier = Modifier.width(190.dp))



                Column {
                    Spacer(modifier = Modifier.height(10.dp)) // Move FT text slightly down
                    Text(text = "28'"
                        , color = androidx.compose.ui.graphics.Color.White
                        , textAlign = TextAlign.Start)

                }




                Text(text = "2"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Right)
            }

            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(38.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Text(text = "Liverpool"
                    , color = androidx.compose.ui.graphics.Color.White
                )
                Text(text = "3"
                    , color = androidx.compose.ui.graphics.Color.White
                    , textAlign = TextAlign.Right)



            }


        }



    }


}



@Composable
fun previewLive(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(

            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(android.graphics.Color.parseColor("#000000")),
                    Color(android.graphics.Color.parseColor("#FF9900"))
                    )
                )
            )


        ){
            logo()
            PremBar(navController)
            kalender()
            SearchFunktion()



        }


    }




@Preview
@Composable
private fun LiveView() {
    previewLive(navController = rememberNavController())
}




