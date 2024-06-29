package com.example.testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testing.navbar.items
import com.example.testing.ui.theme.TestingTheme

import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            TestingTheme {
                // A surface container using the 'background' color from the theme


                var selectedNavItemIndex by remember { mutableStateOf(0) }
                val navController = rememberNavController()


                Scaffold(

                    bottomBar = {
                        NavigationBar {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = selectedNavItemIndex == index,
                                    onClick = { selectedNavItemIndex = index
                                        when (index) {
                                            0 -> navController.navigate(SongScreen)
                                            1 -> navController.navigate(PlaylistScreen)
                                            2 -> navController.navigate(SearchScreen)
                                            3 -> navController.navigate(SettingScreen)
                                        }},
                                    label = { Text(text = item.title) },
                                    icon = {
                                        BadgedBox(badge = {
                                            when {
                                                item.badgeCount != null -> {
                                                    Badge { Text(text = item.badgeCount.toString()) }
                                                }
                                                item.hasNews -> {
                                                    Badge()
                                                }
                                            }
                                        }) {
                                            Icon(
                                                imageVector = if (index == selectedNavItemIndex) {
                                                    item.selectedIcon
                                                } else {
                                                    item.unselectedIcon
                                                },
                                                contentDescription = item.title
                                            )
                                        }
                                    }
                                )
                            }
                        }
                    },
                    content = { innerPadding ->
                        Box(modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()){
                            NavHost(navController = navController, startDestination = SongScreen) {
                                composable<SongScreen>{
                                    Text(text = "SongScreen")
                                }
                                composable<PlaylistScreen>{
                                    Text(text = "PlaylistScreen")
                                }
                                composable<SearchScreen>{
                                    Text(text = "SearchScreen")
                                }
                                composable<SettingScreen>{
                                    Text(text = "SettingScreen")
                                }

                            }
                        }
                    }
                )
            }
        }
    }
}

// songs playlist search settings

@Serializable
object SongScreen

@Serializable
object PlaylistScreen

@Serializable
object SearchScreen

@Serializable
object SettingScreen

@Serializable
data class ScreenB(
    val name: String?,
    val age: Int
)