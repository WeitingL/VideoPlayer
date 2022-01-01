package com.weiting.videoplayer.data

class VideoRepository(private val remoteDataSource: RemoteDataSource) : RemoteDataSource {

    override fun getAllVideo(): List<String> {
        return remoteDataSource.getAllVideo()
    }

}