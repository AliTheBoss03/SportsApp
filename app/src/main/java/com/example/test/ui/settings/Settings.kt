package com.example.test.ui.settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.R

@Composable
fun Settingslogo(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(Color(0xFFFFA000))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
        )
    {
        Image(painter = painterResource(id = R.drawable.baseline_settings_24), contentDescription = "Settings",
        modifier = Modifier
            .height(52.dp)
            .width(52.dp)
            .padding(horizontal = 16.dp)

        )
        Text(text = "Settings",
            modifier = Modifier, color = Color.White, fontSize = 20.sp)




    }
}
@Composable
fun Accountsetting() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 190.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Account Settings",
                modifier = Modifier, color = Color.White, fontSize = 20.sp
            )


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Edit Profile",
                modifier = Modifier, color = Color.White, fontSize = 20.sp
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = "Edit Profile",
                modifier = Modifier
                    .height(52.dp)
                    .width(52.dp)
                    .padding(horizontal = 16.dp)
            )


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Change password",
                modifier = Modifier, color = Color.White, fontSize = 20.sp
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = "Change password",
                modifier = Modifier
                    .height(52.dp)
                    .width(52.dp)
                    .padding(horizontal = 16.dp)
            )


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Push notifications",
                modifier = Modifier, color = Color.White, fontSize = 20.sp
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_toggle_off_24),
                contentDescription = "Push notifications",
                modifier = Modifier
                    .height(52.dp)
                    .width(52.dp)
                    .padding(horizontal = 16.dp))


    }
    }


}
@Composable
fun moresettings() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 190.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "More",
                modifier = Modifier, color = Color.White, fontSize = 20.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(text = "About us",
                modifier = Modifier, color = Color.White, fontSize = 20.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                    contentDescription = "About us",
                    modifier = Modifier
                        .height(52.dp)
                        .width(52.dp)
                        .padding(horizontal = 16.dp))


            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(text = "Privacy policy",
                    modifier = Modifier, color = Color.White, fontSize = 20.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                    contentDescription = "Privacy policy",
                    modifier = Modifier
                        .height(52.dp)
                        .width(52.dp)
                        .padding(horizontal = 16.dp))


            }
                }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(text = "Terms and condition",
                modifier = Modifier, color = Color.White, fontSize = 20.sp
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = "Terms and condition",
                modifier = Modifier
                    .height(52.dp)
                    .width(52.dp)
                    .padding(horizontal = 16.dp))


        }
            }
        }











@Preview
@Composable
fun Previewsettingspage() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(android.graphics.Color.parseColor("000000")),
                    Color(android.graphics.Color.parseColor("FF9900"))

                )
            )
        )
    ) {
        Settingslogo()
        Accountsetting()
        moresettings()

    }
}


