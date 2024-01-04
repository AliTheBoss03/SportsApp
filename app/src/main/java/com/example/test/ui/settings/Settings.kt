package com.example.test.ui.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.test.R

@Composable
fun SettingsLogo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
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
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun AccountSetting() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SectionHeader("Account Settings")
        SettingItem("App Theme", R.drawable.baseline_toggle_off_24)
    }
}

@Composable
fun MoreSettings(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SectionHeader("More")
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            onClick = { navController.navigate("about us") },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White, // Hvid farve for teksten
            )
        ) {
            Text("About Us")
        }
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            onClick = { navController.navigate("contact us") },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White, // Hvid farve for teksten
            )
        ) {
            Text("Contact Us")
        }
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            onClick = { navController.navigate("Privacy Policy") },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White, // Hvid farve for teksten
            )
        ) {
            Text("Privacy Policy")
        }
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            onClick = { navController.navigate("terms and conditions") },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White, // Hvid farve for teksten
            )
        ) {
            Text("Terms and Conditions")
        }
    }
}



@Composable
fun ButtonSettingItem(text: String, iconId: Int, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.White
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = text,
                fontSize = 20.sp
            )
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = text,
                modifier = Modifier.size(52.dp)
            )
        }
    }
}


@Composable
fun SettingItem(text: String, iconId: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = iconId),
            contentDescription = text,
            modifier = Modifier
                .size(52.dp)
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun SectionHeader(title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF9E9E9E),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Divider(
            color = Color(0xFF9E9E9E),
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}
@Composable
@Preview(showBackground = true, widthDp = 360, heightDp = 640)
fun PreviewSettingsPage(){
    SettingsPage(rememberNavController())
}
@Composable
fun SettingsPage(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Black,
                        Color(0xFFFF9900)
                    ),
                    startY = Float.POSITIVE_INFINITY,
                    endY = 0f
                )
            )
    ) {
        Column {
            SettingsLogo()
            AccountSetting()
            MoreSettings(navController)
        }
    }
}