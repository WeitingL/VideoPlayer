package com.weiting.videoplayer

import android.app.Application
import com.weiting.videoplayer.data.VideoRepository
import kotlin.properties.Delegates

class GlobalApplication : Application() {

    lateinit var database: VideoRepository

    val videoRepository: VideoRepository
        get() = DatabaseLocator.provideRepo()

    companion object{
        var  application: GlobalApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()

        database = videoRepository
        application = this

    }

}