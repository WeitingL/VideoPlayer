package com.weiting.videoplayer.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weiting.videoplayer.data.VideoRepository
import com.weiting.videoplayer.ui.videolist.VideoListViewModel
import java.lang.IllegalArgumentException

class VideoListViewModelFactory(private val videoRepository: VideoRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(VideoListViewModel::class.java) ->
                    VideoListViewModel(videoRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}