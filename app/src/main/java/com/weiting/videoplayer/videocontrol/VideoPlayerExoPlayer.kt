package com.weiting.videoplayer.videocontrol

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class VideoPlayerExoPlayer() {

    private lateinit var videoUri: Uri
    private lateinit var exoPlayer: ExoPlayer
    private lateinit var videoUriList: List<String>
    private var currentPosition = 0

    fun getVideoResource (uri: String) {
        videoUri = Uri.parse(uri)
    }

    fun getVideos(list: List<String>){
        videoUriList = list
    }

    fun getCurrentPlayPosition(position: Int){
        currentPosition = position
    }

    fun setExoPlayer(context: Context): ExoPlayer{
        exoPlayer = ExoPlayer.Builder(context).build()

        exoPlayer.setMediaItems(getMediaItems(videoUriList))
        return exoPlayer
    }

    private fun getMediaItems(list: List<String>): List<MediaItem> {
        val uriList = list.map {
            it -> MediaItem.fromUri(it)
        }
        return uriList
    }

    fun playExoPlayer(){
        exoPlayer.apply {
            prepare()
            play()
        }
    }

    fun destroyExoPlayer(){
        exoPlayer.release()
    }





}