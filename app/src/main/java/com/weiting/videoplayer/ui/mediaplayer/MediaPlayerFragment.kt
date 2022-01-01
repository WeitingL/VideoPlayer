package com.weiting.videoplayer.ui.mediaplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.weiting.videoplayer.databinding.FragmentMediaplayerBinding

class MediaPlayerFragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMediaplayerBinding.inflate(inflater, container, false)


        return binding.root
    }

}