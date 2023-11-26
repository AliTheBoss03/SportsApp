package com.example.test.ui.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
fun SettingsLogo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(Color(0xFFFFA000))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_settings_24),
            contentDescription = "Settings",
            modifier = Modifier
                .size(52.dp)
                .padding(horizontal = 16.dp)
        )
        Text(
            text = "Settings",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@Composable
fun AccountSetting() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 190.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
    ) {
        // Gentag dette mønster for hver Row i denne Column
        SettingItem("Account Settings", R.drawable.baseline_keyboard_arrow_right_24)
        SettingItem("Edit Profile", R.drawable.baseline_keyboard_arrow_right_24)
        SettingItem("Change Password", R.drawable.baseline_keyboard_arrow_right_24)
        SettingItem("Push Notifications", R.drawable.baseline_toggle_off_24)
    }
}

@Composable
fun MoreSettings() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 190.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
    ) {
        // Gentag dette mønster for hver Row i denne Column
        SettingItem("More", R.drawable.baseline_keyboard_arrow_right_24)
        SettingItem("About Us", R.drawable.baseline_keyboard_arrow_right_24)
        SettingItem("Privacy Policy", R.drawable.baseline_keyboard_arrow_right_24)
        SettingItem("Terms and Conditions", R.drawable.baseline_keyboard_arrow_right_24)
    }
}

@Composable
fun SettingItem(text: String, iconId: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f)) // Tilføj spacer for at skubbe ikonet til højre
        Image(
            painter = painterResource(id = iconId),
            contentDescription = text,
            modifier = Modifier
                .size(52.dp)
                .padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Black,
                        Color(0xFFFF9900)
                    )
                )
            )
    ) {
        SettingsLogo()
        AccountSetting()
        MoreSettings()
    }
}
