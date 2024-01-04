import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext


@Composable
fun SimpleBackButton(navController: NavHostController) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}

@Composable
fun PrivacyPolicy(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
            .padding(16.dp)
    ) {
        Column {
            SimpleBackButton(navController)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Privacy Policy",
                color = Color.White,
                fontSize = 24.sp,
                lineHeight = 30.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "At Score Ball, your privacy is of utmost importance. We are committed to protecting your personal " +
                        "information and ensuring transparency about the data we collect and how it's used. Our policy details " +
                        "the measures we take to safeguard your data and your rights as a user. We strive to foster trust and " +
                        "provide a secure experience in your journey through the world of football.",
                color = Color.White,
                fontSize = 16.sp,
                lineHeight = 24.sp
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrivacyPolicy() {
    PrivacyPolicy(NavHostController(LocalContext.current))}
