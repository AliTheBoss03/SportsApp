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

val backgroundBrush = Brush.verticalGradient(
    colors = listOf(
        Color.Black,
        Color(0xFFFF9900)
    )
)

@Composable
fun BackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.White // Adjust the color as needed
        )
    }
}

@Composable
fun AboutUs(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
            .padding(16.dp)
    ) {
        Column {

            BackButton {

                navController.popBackStack()
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "About Score Ball",
                color = Color.White,
                fontSize = 24.sp,
                lineHeight = 30.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Welcome to Score Ball - the innovative soccer app created for sports enthusiasts worldwide. " +
                        "Our mission is to revolutionize your soccer experience with a platform that's as " +
                        "interactive and informative as it is user-friendly. Dive into the heart of soccer " +
                        "with live scores, detailed event insights, and viral football news. Join our community " +
                        "and live the sport that's not just a game, but a lifestyle. Score Ball is your ultimate " +
                        "guide to the world of football.",
                color = Color.White,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAboutUs() {
    AboutUs(NavHostController(LocalContext.current))
}
