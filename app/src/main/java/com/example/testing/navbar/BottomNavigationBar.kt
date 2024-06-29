package com.example.testing.navbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit,
    navController: NavController
) {

    Scaffold(

        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = { onItemSelected(index) },
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
                                    imageVector = if (index == selectedItemIndex) {
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
                .fillMaxSize())
        }
    )
}


@Serializable
object ScreenSongs

@Serializable
object ScreenPlaylist

@Serializable
object ScreenSearch

@Serializable
object ScreenSettings
