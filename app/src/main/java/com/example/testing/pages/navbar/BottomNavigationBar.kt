package com.example.testing.pages.navbar

import android.util.Log
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

import androidx.navigation.NavController
import com.example.testing.MainViewModel
import com.example.testing.pages.content.PlaylistScreen
import com.example.testing.pages.content.SearchScreen
import com.example.testing.pages.content.SettingScreen
import com.example.testing.pages.content.SongScreen
@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit,
    navController: NavController
) {
    Log.d("Scaffold", "inNav")
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { onItemSelected(index)
                    Log.d("Scaffold", "Navigating to Screen $index ")
                    when (index) {
                        0 -> navController.navigate(SongScreen)
                        1 -> navController.navigate(PlaylistScreen)
                        2 -> navController.navigate(SearchScreen)
                        3 -> navController.navigate(SettingScreen)
                    } },
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
    Log.d("Scaffold", "outNav")
}

