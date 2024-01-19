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

@Composable
fun newBackButton(navController: NavHostController) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}

@Composable
fun TermsAndConditions(navController: NavHostController) {
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
                text = "Terms and Conditions",
                color = Color.White,
                fontSize = 24.sp,
                lineHeight = 30.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "By using Score Ball, you agree to the terms that govern its usage. " +
                        "These terms are designed to ensure a fair and enjoyable experience for all our users. " +
                        "We encourage you to review them carefully to understand your rights and responsibilities " +
                        "as you engage with our services. Let's continue to celebrate our love for football in a way " +
                        "that's respectful and in the spirit of the game.",
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
fun PreviewTermsAndConditions() {
    TermsAndConditions(NavHostController(LocalContext.current))
}

