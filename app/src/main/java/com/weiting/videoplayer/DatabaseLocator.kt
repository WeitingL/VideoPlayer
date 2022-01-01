package com.weiting.videoplayer

import com.weiting.videoplayer.data.VideoRepository
import com.weiting.videoplayer.data.remote.RemoteDataSource

object DatabaseLocator {

    @Volatile
    var videoRepository : VideoRepository? = null

    fun provideRepo(): VideoRepository{
        synchronized(this){
            return videoRepository?: createRepository()
        }
    }

    private fun createRepository(): VideoRepository{
        return VideoRepository(RemoteDataSource)
    }

}