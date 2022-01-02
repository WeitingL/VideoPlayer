package com.weiting.videoplayer.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weiting.videoplayer.data.VideoRepository
import com.weiting.videoplayer.ui.mediaplayer.MediaPlayerViewModel
import java.lang.IllegalArgumentException

class MediaPlayerViewModelFactory(
    private val videoRepository: VideoRepository,
    private val position: Int,
    private val uri: String
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(MediaPlayerViewModel::class.java) ->
                    MediaPlayerViewModel(videoRepository, position, uri)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}