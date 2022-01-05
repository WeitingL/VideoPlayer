package com.weiting.videoplayer.videocontrol

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class VideoPlayerExoPlayer() {

    private lateinit var videoResource: Uri
    private lateinit var exoPlayer: ExoPlayer

    fun getVideoResource (uri: String) {
        videoResource = Uri.parse(uri)
    }


    fun setExoPlayer(context: Context): ExoPlayer{
        exoPlayer = ExoPlayer.Builder(context).build()

        Log.i("uri", videoResource.toString())

        exoPlayer.setMediaItem(MediaItem.fromUri(videoResource))
        return exoPlayer
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