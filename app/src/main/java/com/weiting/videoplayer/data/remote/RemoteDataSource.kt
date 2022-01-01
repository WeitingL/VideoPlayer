package com.weiting.videoplayer.data.remote

import com.weiting.videoplayer.data.RemoteDataSource

object RemoteDataSource : RemoteDataSource {

    override fun getAllVideo(): List<String> {
        return listOf(
            "https://storage.googleapis.com/exoplayer-test-media-1/mp4/android-screens-10s.mp4",
            "https://storage.googleapis.com/exoplayer-test-media-1/mp4/android-screens-25s.mp4",
            "https://storage.googleapis.com/exoplayer-test-media-1/mp4/frame-counter-one-hour.mp4",
            "https://html5demos.com/assets/dizzy.mp4",
            "https://storage.googleapis.com/exoplayer-test-media-1/gen-3/screens/dash-vod-single-segment/video-avc-baseline-480.mp4",
            "https://storage.googleapis.com/exoplayer-test-media-1/mp4/dizzy-with-tx3g.mp4",
            "https://storage.googleapis.com/exoplayer-test-media-1/gen-3/screens/dash-vod-single-segment/video-137.mp4",
            "https://storage.googleapis.com/downloads.webmproject.org/av1/exoplayer/bbb-av1-480p.mp4"
        )
    }

}