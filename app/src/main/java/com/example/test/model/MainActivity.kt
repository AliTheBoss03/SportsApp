package com.example.test.model

import AboutUs
import ContactUs

import PrivacyPolicy
import TermsAndConditions
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.test.data.LiveMatchesData.LiveMatches
import com.example.test.prevMyScreen
import com.example.test.ui.Livescreen.previewLive
import com.example.test.ui.League.PreviewPremierLeagueScreen
import com.example.test.ui.MatchView.EventDetailsView
import com.example.test.ui.MatchView.LineUpView
import com.example.test.ui.Predection.PreviewMatchScreen
import com.example.test.ui.UpcomingMatches.Upcoming
import com.example.test.ui.favourite.Favourite
import com.example.test.ui.frontpage.FrontPage
import com.example.test.ui.news.NewsScreenPreview
import com.example.test.ui.results.ResultsView
import com.example.test.ui.settings.SettingsPage
import com.example.test.ui.theme.TestTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
    val route: String,
    val icon: ImageVector,


)

const val BaseUrl = "https://www.thesportsdb.com/"
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                val navController = rememberNavController()
                val liveMatches = runBlocking(Dispatchers.IO) {
                    //fetchData()
                }
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = "home",
                                    icon = Icons.Filled.Home
                                ),
                                BottomNavItem(
                                    name = "Upcoming",
                                    route = "upcoming",
                                    icon = Icons.Filled.DateRange
                                ),
                                BottomNavItem(
                                    name = "Favourite",
                                    route = "favourite",
                                    icon = Icons.Filled.Favorite
                                ),
                                BottomNavItem(
                                    name = "Predictions",
                                    route = "predictions",
                                    icon = Icons.Filled.Person
                                ),
                                BottomNavItem(
                                    name = "League",
                                    route = "league",
                                    icon = Icons.Filled.List
                                ),
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            })
                    }
                ) {
                    Navigation(navController = navController)


                }
            }


            }
            }
    /**
    private suspend fun fetchData(): List<String> {
        // Implement your logic to fetch data
        // Return the data as per your actual data structure
        //return GetLivescore().CallGetLivescore()
    }*/

}


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            FrontPage(navController)
        }
        composable("results") {
            ResultsView(navController)
        }
        composable("favourite") {
            Favourite(navController)
        }
        composable("predictions") {
            PreviewMatchScreen()
        }
        composable("league") {
            PreviewPremierLeagueScreen()
        }
        composable("settings") {
            SettingsPage(navController)
        }
        composable("news") {
            NewsScreenPreview()
        }
        composable("search") {
            com.example.test.ui.search.previewResults()
        }
        composable("livescreen") {
            //previewLive(navController)
            prevMyScreen()
        }
        composable("upcoming") {
            Upcoming(navController)
        }
        composable("Eventdetail") {
            EventDetailsView(navController)
        }
        composable("LineUp") {
            LineUpView(navController)
        }
        composable("about us") {
            AboutUs(navController)
        }
        composable("contact us") {
            ContactUs(navController)
        }
        composable("Privacy Policy") {
            PrivacyPolicy(navController)
        }
        composable("terms and conditions") {
            TermsAndConditions(navController)
        }

        composable("newsDetail/{newsTitle}") { backStackEntry ->
            val newsTitle = backStackEntry.arguments?.getString("newsTitle")

        }
        composable("newsDetail/{newsTitle}") { /* ... */ }
        // ... Andre ruter defineret ...
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {


    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomAppBar (
        contentColor = Color.Black,
        tonalElevation = 5.dp
    ){
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(item) },
                modifier = Modifier,
                colors = NavigationBarItemDefaults.colors(selectedIconColor = Color.Green),
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(badge = {
                                Text(text = item.badgeCount.toString())
                            }) {
                                Icon(   imageVector = item.icon,
                                        contentDescription = item.name)
                            }
                        } else {
                            Icon(   imageVector = item.icon,
                                contentDescription = item.name)
                        }
                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                                )
                        }
                    }
                }
            )
        }

    }
}

