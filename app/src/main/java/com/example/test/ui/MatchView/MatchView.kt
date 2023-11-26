package com.example.test.ui.MatchView


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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.R

class MatchView {
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


@Composable
fun searchBar() {
    Column(
        modifier = Modifier
            .height(65.dp)
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {
        Row (
            modifier = Modifier
                .width(107.dp)
                .height(31.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#FF9900")),
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#FF9900"))
                        )
                    )
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top

        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_newspaper_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(22.dp)
                    .width(27.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "Image",
                modifier = Modifier
                    .height(22.dp)
                    .width(27.dp)
            )
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


@Composable
fun backButton(){

}


@Composable
fun Team(){

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp)
            .height(125.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){




        Row (
            Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .height(32.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically




        ){
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Man UTD"
                , color = androidx.compose.ui.graphics.Color.White
                , textAlign = TextAlign.Start

            )


            //Logo for man utd
            Image(
                painter = painterResource(id = R.drawable.manutd), // Erstat med det faktiske ID for dit logo
                contentDescription = "Man UTD Logo",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .padding(start = 12.dp) // Juster afstanden efter behov

            )


            Spacer(modifier = Modifier.width(175.dp))


            //Logo for man city
            Image(
                painter = painterResource(id = R.drawable.mancity), // Erstat med det faktiske ID for dit logo
                contentDescription = "Man CITY Logo",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .padding(end= 12.dp) // Juster afstanden efter behov
            )




            Text(text = "Man City"
                , color = androidx.compose.ui.graphics.Color.White
                , textAlign = TextAlign.Right
            )
            Spacer(modifier = Modifier.weight(1f))

        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp), // Juster afstanden efter behov
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "21:00",
                color = androidx.compose.ui.graphics.Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Today",
                color = androidx.compose.ui.graphics.Color.White,
                textAlign = TextAlign.Center
            )


        }
    }
}


@Composable
fun LineUP() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
            .height(125.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 85.dp)
                .height(125.dp)
            .border(2.dp, Color.White),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Line-Up",
                color = androidx.compose.ui.graphics.Color.White,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold

            )
            Spacer(modifier = Modifier.width(75.dp))
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(20.dp)
                    .background(androidx.compose.ui.graphics.Color.White)
            )
            Spacer(modifier = Modifier.width(75.dp))
            Text(
                text = "Table",
                color = androidx.compose.ui.graphics.Color.White,
                textAlign = TextAlign.Right
            )
            Spacer(modifier = Modifier.weight(1f))

        }



    }
}

@Composable
fun FootballField() {

    Box(
        modifier = Modifier
            .padding(top = 250.dp)
            .fillMaxWidth()
            .height(600.dp)
            // Farven på fodboldbanen
            .background(

                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(android.graphics.Color.parseColor("#FFA500")),
                        Color(android.graphics.Color.parseColor("#000000")),
                        Color(android.graphics.Color.parseColor("#FFA500"))
                    )
                )

            )
            // En hvid border rundt om banen
            .border(3.dp, Color.White),




    ) {
        // Mål (øverst)
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(35.dp)
                .border(3.dp, Color.White)
                .align(Alignment.TopCenter)



        )
        // Felt
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(80.dp)
                .border(3.dp, Color.White)
                .align(Alignment.TopCenter)
        )



        // Mål (nederst)
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(35.dp)
                .border(3.dp, Color.White)
                .align(Alignment.BottomCenter)
        )

        // Felt
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(80.dp)
                .border(3.dp, Color.White)
                .align(Alignment.BottomCenter)
        )



        // Midterlinje
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(Color.White)
                .align(Alignment.Center)
        )

        // Centercirkel
        Box(
            modifier = Modifier
                .width(90.dp)
                .height(90.dp)
                .background(Color.Transparent)
                .border(3.dp, Color.White, CircleShape)
                .align(Alignment.Center)
        )
    }
}




@Preview
@Composable
fun previewScreen() {
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


        searchBar()
        logo()
        Team()
        FootballField()
        LineUP()

    }


}
