package com.weiting.videoplayer.videocontrol

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class VideoPlayerExoPlayer() {

//    private lateinit var videoUri: Uri

    private lateinit var exoPlayer: ExoPlayer
    private lateinit var videoUriList: List<String>
    private var playPosition = 0

//    fun getVideoResource(uri: String) {
//        videoUri = Uri.parse(uri)
//    }

    fun getVideos(list: List<String>) {
        videoUriList = list
    }

    fun getCurrentPlayPosition(position: Int) {
        playPosition = position
    }

    fun setExoPlayer(context: Context): ExoPlayer {
        exoPlayer = ExoPlayer.Builder(context).build()

        exoPlayer.apply {
            addMediaSources(getMediaResources(videoUriList))

            addListener(object : Player.Listener {

                override fun onPlaybackStateChanged(playbackState: Int) {
                    super.onPlaybackStateChanged(playbackState)

                    when (playbackState) {
                        Player.STATE_BUFFERING ->
                            Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                        Player.STATE_READY ->
                            Toast.makeText(context, "LoadingFinished", Toast.LENGTH_SHORT).show()
                        else -> {
                        }
                    }
                }

                override fun onPlayerErrorChanged(error: PlaybackException?) {
                    super.onPlayerErrorChanged(error)
                    Log.e("ExoPlayer", "Exception: $error")
                    Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show()
                }

            })
        }

        return exoPlayer
    }

    private fun getMediaResources(list: List<String>): List<MediaSource> {
        val sourceList = list.mapIndexed { index, it ->
            createMediaSource(it, index)
        }
        return sourceList
    }

    private fun createMediaSource(video: String, position: Int): MediaSource {
        val dataSourceFactory = DefaultHttpDataSource.Factory()
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .setTag(position)
            .createMediaSource(MediaItem.fromUri(video))
    }

    fun playExoPlayer() {
        exoPlayer.apply {
            seekTo(playPosition, 0L)
            prepare()
            play()
        }
    }

    fun destroyExoPlayer() {
        exoPlayer.release()
    }


}