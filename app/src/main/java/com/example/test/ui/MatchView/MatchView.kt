package com.example.test.ui.MatchView


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                .height(25.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically




        ){
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Man UTD"
                , color = androidx.compose.ui.graphics.Color.White
                , textAlign = TextAlign.Start


            )
            Spacer(modifier = Modifier.width(220.dp))

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
                .height(125.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Line-Up",
                color = androidx.compose.ui.graphics.Color.White,
                textAlign = TextAlign.Start
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








@Preview
@Composable
fun previewnigga() {
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
        LineUP()





    }


}
