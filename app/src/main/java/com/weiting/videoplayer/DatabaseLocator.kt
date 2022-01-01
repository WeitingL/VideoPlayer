package com.weiting.videoplayer

import com.weiting.videoplayer.data.VideoRepository
import com.weiting.videoplayer.data.remote.RemoteDataSource

object DatabaseLocator {

    // To verify the repository existed
    // If the database is not initialized, the repo is created here.

    @Volatile
    var videoRepository : VideoRepository? = null

    //Because it only one datasource and repo, it can check the internet condition to switch the local database.
    fun provideRepo(): VideoRepository{
        synchronized(this){
            return videoRepository?: createRepository()
        }
    }

    private fun createRepository(): VideoRepository{
        return VideoRepository(RemoteDataSource)
    }

}