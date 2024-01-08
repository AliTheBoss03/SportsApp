package com.example.test.ui.MatchView
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
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
                color = androidx.compose.ui.graphics.Color.White,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold


            )




            Spacer(modifier = Modifier.width(35.dp))


            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(20.dp)
                    .background(androidx.compose.ui.graphics.Color.White)


            )


            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { navController.navigate("table") },
                modifier = Modifier.padding(1.dp),
                colors = ButtonDefaults.buttonColors( Color.Transparent),
            ) {
                Text(
                    text = "Table",
                    color = androidx.compose.ui.graphics.Color.White,
                    textAlign = TextAlign.Right

                )
            }
        }
    }
}



@Composable
fun Stadium() {
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
                painter = painterResource(id = R.drawable.stadium), // Erstat med din billedressource
                contentDescription = "Stadium Image",
                modifier = Modifier.size(45.dp) // Justér størrelsen efter behov
                .padding(start = 5.dp),

            )




            Text(
                text = "Stadium",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Start,



            )

            Spacer(modifier = Modifier.width(125.dp))
            Text(
                text = "Old Traford (Man UTD)",
                color = Color.White,
                textAlign = TextAlign.Right,
            )
            Spacer(modifier = Modifier.weight(1f))

        }

    }
}



@Composable
fun Ref() {
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




            Spacer(modifier = Modifier.width(200.dp))
            Text(
                text = "Frank Castle",
                color = Color.White,
                textAlign = TextAlign.Right,
            )
            Spacer(modifier = Modifier.weight(1f))

        }


    }
}



@Composable
fun description() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 350.dp)
            .height(300.dp),
    ) {


        Divider(
            color = Color.White,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 12.dp) // Tilføj vertical padding omkring Divider
        )




        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.desc), // Erstat med din billedressource
                contentDescription = "Ref Image",
                modifier = Modifier.size(25.dp) // Justér størrelsen efter behov
            )

            Spacer(modifier = Modifier.width(1.dp)) // Tilføj en lille afstand mellem billede og tekst

            Text(
                text = "Description",
                color = Color.White,
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 5.dp) // Tilføj start padding til teksten
            )
        }


        Text(
            text = "A top showdown between arch-rivals that is " +
                    "decisive for the 1st place starts today." +
                    " Both sides have been in superb form with an " +
                    "average goalscorer of 3 per match, but who will" +
                    " end up taking the victory to reach the top?.",
            color = Color.White,
            lineHeight = 24.sp,
            modifier = Modifier.padding(top = 16.dp)
                .padding(start = 48.dp)
                .width(320.dp)
        )

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
        Team()
        LineUP2(navController)
        Stadium()
        Ref()
        description()

    }
}

@Preview
@Composable
private fun previewScreen() {
    EventDetailsView(navController = rememberNavController())
}



