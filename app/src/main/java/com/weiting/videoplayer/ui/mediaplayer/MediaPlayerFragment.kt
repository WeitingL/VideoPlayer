package com.weiting.videoplayer.ui.mediaplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.weiting.videoplayer.GlobalApplication
import com.weiting.videoplayer.databinding.FragmentMediaplayerBinding
import com.weiting.videoplayer.factory.MediaPlayerViewModelFactory

class MediaPlayerFragment : Fragment() {

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

        viewModel.currentMedia.observe(viewLifecycleOwner){
            binding.text.text = it
        }

        return binding.root
    }

}