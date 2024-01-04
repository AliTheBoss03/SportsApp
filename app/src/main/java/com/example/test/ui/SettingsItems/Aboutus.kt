
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val backgroundBrush = Brush.verticalGradient(
    colors = listOf(
        Color.Black,
        Color(0xFFFF9900)
    )
)

@Composable
fun AboutUs() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
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

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PreviewAboutUs() {
    AboutUs()
}
