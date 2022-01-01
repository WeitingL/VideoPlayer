package com.weiting.videoplayer.ui.videolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavGraphNavigator
import androidx.navigation.fragment.findNavController
import com.weiting.videoplayer.NavigationDirections
import com.weiting.videoplayer.databinding.FragmentVideolistBinding

class VideoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentVideolistBinding.inflate(inflater, container, false)

        binding.test.setOnClickListener {
            findNavController().navigate(NavigationDirections.actionGlobalMediaPlayerFragment())
        }

        return binding.root
    }

}