package com.example.testing.pages.navbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.QueueMusic
import androidx.compose.material.icons.automirrored.outlined.QueueMusic
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null,
    val hasNews: Boolean = false

)

val items = listOf(
    BottomNavigationItem(
        title = "songs",
        selectedIcon = Icons.Filled.MusicNote,
        unselectedIcon = Icons.Outlined.MusicNote
    ),
    BottomNavigationItem(
        title = "playlist",
        selectedIcon = Icons.AutoMirrored.Filled.QueueMusic,
        unselectedIcon = Icons.AutoMirrored.Outlined.QueueMusic
    ),
    BottomNavigationItem(
        title = "search",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search
    ),
    BottomNavigationItem(
        title = "settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        hasNews = true
    )
)