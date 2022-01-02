package com.weiting.videoplayer.ui.videolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavGraphNavigator
import androidx.navigation.fragment.findNavController
import com.weiting.videoplayer.GlobalApplication
import com.weiting.videoplayer.NavigationDirections
import com.weiting.videoplayer.databinding.FragmentVideolistBinding
import com.weiting.videoplayer.factory.VideoListViewModelFactory

class VideoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentVideolistBinding.inflate(inflater, container, false)

        val vmFactory = VideoListViewModelFactory(GlobalApplication.application.database)
        val viewModel = ViewModelProvider(this, vmFactory).get(VideoListViewModel::class.java)
        val adapter = VideoListAdapter(VideoListAdapter.OnClickListener{ position, uri ->
            findNavController().navigate(NavigationDirections.actionGlobalMediaPlayerFragment(position, uri))
        })

        viewModel.videoList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        binding.rvVideoList.adapter = adapter
        return binding.root
    }

}