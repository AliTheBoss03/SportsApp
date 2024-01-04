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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

val gradientBackground = Brush.verticalGradient(
    colors = listOf(
        Color.Black,
        Color(0xFFFF9900)
    )
)

@Composable
fun OldBackButton(navController: NavHostController) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}

@Composable
fun ContactUs(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
            .padding(16.dp)
    ) {
        OldBackButton(navController)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Contact Us",
            color = Color.White,
            fontSize = 24.sp,
            lineHeight = 30.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "At Score Ball, our customers are the heart of our community. " +
                    "We are dedicated to providing you with exceptional service and support. " +
                    "Your feedback, questions, and engagement drive us to continually improve and " +
                    "enhance your experience. Feel free to reach out; we’re here to help and ensure " +
                    "you stay connected with the sport you love.",
            color = Color.White,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Contact via mail: Customerservice@scoreball.com",
            color = Color.White,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Contact via phone service: 52585907\n" +
                    "-------------------------------------------------------------------\n" +
                    "Phone availability \n" +
                    "-------------------------------------------------------------------\n" +
                    "Monday: 8-17\n" +
                    "Tuesday: 8-13\n" +
                    "Wednesday: Closed\n" +
                    "Thursday: 8-17\n" +
                    "Friday: 8-13\n" +
                    "Weekends: Closed",
            color = Color.White,
            fontSize = 16.sp,
            lineHeight = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContactUs() {
    ContactUs(NavHostController(LocalContext.current))
}
