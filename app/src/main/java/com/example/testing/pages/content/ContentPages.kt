package com.example.testing.pages.content

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.testing.MainViewModel
import com.example.testing.VideoPlayer
import kotlinx.serialization.Serializable

@Composable

fun ContentPages(
    innerPadding: PaddingValues,
    navController: NavHostController,
    viewModel: MainViewModel
){

    Log.d("Scaffold", "inContent")
    Box(modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize()){
        NavHost(navController = navController, startDestination = SongScreen) {
            composable<SongScreen>{
                Log.d("Scaffold", "Navigated to Song Screen")
                Text(text = "SongScreen")
            }
            composable<PlaylistScreen>{
                Log.d("Scaffold", "Navigated to Playlist Screen")
                VideoPlayer(viewModel = viewModel)

            }
            composable<SearchScreen>{
                Log.d("Scaffold", "Navigated to Search Screen")
                Text(text = "SearchScreen")
            }
            composable<SettingScreen>{
                Log.d("Scaffold", "Navigated to Settings Screen")
                Text(text = "SettingsScreen")
            }

        }
    }
    Log.d("Scaffold", "outContent")
}



@Serializable
object SongScreen

@Serializable
object PlaylistScreen

@Serializable
object SearchScreen

@Serializable
object SettingScreen