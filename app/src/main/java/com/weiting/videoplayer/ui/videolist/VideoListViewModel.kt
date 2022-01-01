package com.weiting.videoplayer.ui.videolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weiting.videoplayer.data.VideoRepository

class VideoListViewModel(private val videoRepository: VideoRepository) : ViewModel() {

    private val _videoList = MutableLiveData<List<String>>()
    val videoList: LiveData<List<String>>
        get() = _videoList

    init {
        _videoList.value = videoRepository.getAllVideo()
    }


}