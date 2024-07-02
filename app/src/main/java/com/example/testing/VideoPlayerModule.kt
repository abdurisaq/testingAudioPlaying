package com.example.testing

import android.app.Application
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

//@Module
//@InstallIn(ViewModelComponent::class)
//object VideoPlayerModule {
//
//    @Provides
//    @ViewModelScoped
//    fun provideVideoPlayer(app: Application): Player {
//        return ExoPlayer.Builder(app).build()
//    }
//
//    @Provides
//    @ViewModelScoped
//    fun provideMetaDataReader(app: Application): MetaDataReader {
//        return MetaDataReaderImpl(app)
//    }
//}
//
//
 interface VideoPlayerModule{
    val videoPlayer :Player
    val metaDataReader: MetaDataReader


 }
class VideoPlayerModuleImpl(app:Application) :VideoPlayerModule{
    override val videoPlayer: Player by lazy {
        Log.d("Scaffold", "Creating ExoPlayer instance")
        ExoPlayer.Builder(app).build()
    }

    override val metaDataReader: MetaDataReader by lazy {
        Log.d("Scaffold", "Creating MetaDataReader instance")
        MetaDataReaderImpl(app)
    }

}