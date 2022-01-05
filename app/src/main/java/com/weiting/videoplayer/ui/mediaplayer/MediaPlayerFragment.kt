package com.weiting.videoplayer.ui.mediaplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.weiting.videoplayer.GlobalApplication
import com.weiting.videoplayer.databinding.FragmentMediaplayerBinding
import com.weiting.videoplayer.factory.MediaPlayerViewModelFactory
import com.weiting.videoplayer.videocontrol.VideoPlayerExoPlayer

class MediaPlayerFragment : Fragment() {

    lateinit var playerView: StyledPlayerView
    private val playController = VideoPlayerExoPlayer()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMediaplayerBinding.inflate(inflater, container, false)
        val position = MediaPlayerFragmentArgs.fromBundle(requireArguments()).position
        val uri = MediaPlayerFragmentArgs.fromBundle(requireArguments()).uri
        val factory =
            MediaPlayerViewModelFactory(GlobalApplication.application.database, position, uri)
        val viewModel = ViewModelProvider(this, factory).get(MediaPlayerViewModel::class.java)

        playController.getVideoResource(viewModel.currentMedia.value!!)

        playerView = binding.pvVideo
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        playerView.player = playController.setExoPlayer(this.context!!)
        playController.playExoPlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        playController.destroyExoPlayer()
    }

}