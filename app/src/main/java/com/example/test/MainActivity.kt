package com.example.test

import NewsDetailScreen
import NewsDetailScreenPreview
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
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
import com.example.test.Livescreen.previewLive
import com.example.test.ui.League.PreviewPremierLeagueScreen
import com.example.test.ui.UpcomingMatches.previewUpcoming
import com.example.test.ui.favourite.Favourite
import com.example.test.ui.frontpage.FrontPage
import com.example.test.ui.news.NewsScreen
import com.example.test.ui.news.NewsScreenPreview
import com.example.test.ui.results.previewResults
import com.example.test.ui.settings.PreviewSettingsPage
import com.example.test.ui.theme.TestTheme

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
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
                                    name = "Favorites",
                                    route = "favorites",
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
                    com.example.test.Navigation(navController = navController)

                }
            }


            }
       // getMyData()
            }
    /**
    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BaseUrl)
            .build()
            .create(apiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<Table>?> {
            override fun onResponse(call: Call<List<Table>?>, response: Response<List<Table>?>) {
                val responseBody = response.body()!!

                val myStringBuilder = StringBuilder()
                for (Table in responseBody) {
                    myStringBuilder.append(Table.idTeam)
                    myStringBuilder.append("/n")
                }

            }

            override fun onFailure(call: Call<List<Table>?>, t: Throwable) {
                Log.d("MainActivity","onFailure: "+t.message)
            }
        })
    }
    */
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            FrontPage(navController)
        }
        composable("results") {
            previewResults()
        }
        composable("favourites") {
            Favourite(navController)
        }
        composable("predictions") {

        }
        composable("league") {
            PreviewPremierLeagueScreen()
        }
        composable("settings") {
            PreviewSettingsPage()
        }
        composable("news") {
            NewsScreenPreview()
        }
        composable("search") {
            com.example.test.ui.search.previewResults()
        }
        composable("livescreen") {
            previewLive()
        }
        composable("upcoming") {
            previewUpcoming()
        }
        composable("nyhedDetail/{newsTitle}") { backStackEntry ->
            val newsTitle = backStackEntry.arguments?.getString("newsTitle")
            NewsDetailScreen(newsTitle)
        }
        composable("news") {
            NewsScreen(navController = navController)
        }

    }
    }

fun NewsDetailScreen(newsItem: String?) {
    TODO("Not yet implemented")
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomAppBar (
        modifier = modifier,
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

