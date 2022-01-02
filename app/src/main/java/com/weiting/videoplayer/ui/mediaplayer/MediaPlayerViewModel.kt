package com.weiting.videoplayer.ui.mediaplayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weiting.videoplayer.data.VideoRepository

class MediaPlayerViewModel(
    private val videoRepository: VideoRepository,
    private val position: Int,
    private val uri: String
) : ViewModel() {

    private val _currentMedia = MutableLiveData<String>()
    val currentMedia: LiveData<String>
        get() = _currentMedia

    init {
        _currentMedia.value = uri
    }


}