package com.example.testing

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp


class VideoPlayerApp :Application(){

    companion object {
        lateinit var appModule: VideoPlayerModule
    }

    override fun onCreate() {
        Log.d("Scaffold", "Application onCreate")
        super.onCreate()
        appModule = VideoPlayerModuleImpl(this)

    }
}
