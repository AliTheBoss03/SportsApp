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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.test.R

@Composable
fun LineUP2(navController:NavController) {
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
                .border(2.dp, Color.White)
                .padding(start = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Button(
                onClick = { navController.navigate("LineUp") },
                modifier = Modifier.padding(1.dp),
                colors = ButtonDefaults.buttonColors( Color.Transparent),


                ) {
                Text(
                    text = "Line-Up",
                    modifier = Modifier,
                    color = Color.White,
                    textAlign = TextAlign.Start,
                )

            }

            Spacer(modifier = Modifier.width(20.dp))


            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(20.dp)
                    .background(androidx.compose.ui.graphics.Color.White)


            )

            Spacer(modifier = Modifier.width(22.dp))


            Text(
                text = "Event Details",
                color = Color.White,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold


            )
            Spacer(modifier = Modifier.width(35.dp))
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(20.dp)
                    .background(Color.White)


            )
        }
    }
}



@Composable
fun Stadium(city: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 150.dp)
            .height(125.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
                .height(125.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,



            ) {
            Image(
                painter = painterResource(id = R.drawable.stadium),
                contentDescription = "Stadium Image",
                modifier = Modifier.size(45.dp)
                    .padding(start = 5.dp),

                )


            Text(
                text = "Stadium",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Start,



                )

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = city,
                color = Color.White,
                textAlign = TextAlign.Right,
            )
            Spacer(modifier = Modifier.weight(1f))

        }

    }
}



@Composable
fun Ref(referee: String?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 200.dp)
            .height(125.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
                .height(125.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically



        ) {
            Image(
                painter = painterResource(id = R.drawable.ref), // Erstat med din billedressource
                contentDescription = "Ref Image",
                modifier = Modifier.size(45.dp) // Justér størrelsen efter behov
                    .padding(start = 5.dp),

                )

            Text(
                text = "Ref",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Start,
            )




            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = referee ?: "",
                color = Color.White,
                textAlign = TextAlign.Right,
            )
            Spacer(modifier = Modifier.weight(1f))

        }


    }
}


@Composable
fun EventDetailsView(navController: NavController) {
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


        searchBar(navController)
        logo()
        LineUP2(navController)


    }
}

@Preview
@Composable
private fun previewScreen() {
    EventDetailsView(navController = rememberNavController())
}



