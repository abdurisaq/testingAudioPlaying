package com.example.testing

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileOpen
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.ui.PlayerView
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testing.ui.theme.TestingTheme

import androidx.navigation.compose.rememberNavController
import com.example.testing.pages.content.ContentPages
import com.example.testing.pages.content.PlaylistScreen
import com.example.testing.pages.content.SearchScreen
import com.example.testing.pages.content.SettingScreen
import com.example.testing.pages.content.SongScreen
import com.example.testing.pages.navbar.BottomNavigationBar
import com.example.testing.pages.navbar.items
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            TestingTheme {
                // A surface container using the 'background' color from the theme


                var selectedNavItemIndex by remember { mutableStateOf(0) }
                val navController = rememberNavController()

                val viewModel:MainViewModel by viewModels {
                    ViewModelFactory(
                        this,
                        player = VideoPlayerApp.appModule.videoPlayer,
                        metaDataReader =VideoPlayerApp.appModule.metaDataReader
                    )
                }
                //VideoPlayer(viewModel = viewModel)

                Log.d("Scaffold", "inMainFunction")
                Scaffold(

                    bottomBar = {
                        BottomNavigationBar(items,selectedNavItemIndex,onItemSelected = { item -> selectedNavItemIndex = item},navController)
                    },
                    content = { innerPadding ->
                        ContentPages(innerPadding, navController,viewModel)
                    }
                )
                Log.d("Scaffold", "past scaffold")
            }
        }
    }
}



@Serializable
data class ScreenB(
    val name: String?,
    val age: Int
)



//val videoItems by viewModel.videoItems.collectAsState()
//val selectVideoLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(),
//    onResult = {uri ->
//        uri?.let(viewModel::addVideoUri)
//
//    })
//
//var lifeCycle by remember {
//    mutableStateOf(Lifecycle.Event.ON_CREATE)
//}
//val lifeCycleOwner = LocalLifecycleOwner.current
//DisposableEffect(lifeCycleOwner) {
//    val observer = LifecycleEventObserver{ _, event ->
//        lifeCycle = event
//
//    }
//    lifeCycleOwner.lifecycle.addObserver(observer)
//    onDispose {
//        lifeCycleOwner.lifecycle.removeObserver(observer)
//    }
//}
//Column(
//modifier = Modifier
//.fillMaxSize()
//.padding(15.dp)
//
//) {
//    AndroidView(factory =
//    {context ->
//        PlayerView(context).also {
//            it.player = viewModel.player
//        }
//    },
//        update = {
//            when(lifeCycle){
//                Lifecycle.Event.ON_PAUSE -> {
//                    it.onPause()
//                    it.player?.pause()
//                }
//                Lifecycle.Event.ON_RESUME ->{
//                    it.onResume()
//                }
//                else -> Unit
//            }
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .aspectRatio(16 / 9f)
//
//    )
//    Spacer(modifier = Modifier.height(10.dp))
//    IconButton(onClick = {
//        selectVideoLauncher.launch("video/mp4")
//    }) {
//        Icon(imageVector =  Icons.Default.FileOpen,
//            contentDescription = "select Video")
//
//    }
//    Spacer(modifier = Modifier.height(10.dp))
//    LazyColumn(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        items(videoItems) { item ->
//            Text(
//                text = item.name,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable {
//                        viewModel.playVideo(item.content)
//                    }
//                    .padding(16.dp)
//            )
//        }
//    }
//}