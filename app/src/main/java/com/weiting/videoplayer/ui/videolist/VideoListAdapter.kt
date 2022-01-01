package com.weiting.videoplayer.ui.videolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weiting.videoplayer.databinding.FragmentVideolistBinding
import com.weiting.videoplayer.databinding.RowVideoListBinding

class VideoListAdapter : ListAdapter<String, VideoListAdapter.VideoListViewHolder>(DiffCallback) {

    object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem
    }

    inner class VideoListViewHolder(private val binding: RowVideoListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, uri: String) {
            binding.apply {
                tvPosition.text = position.toString()
                tvUri.text = uri
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoListViewHolder {
        return VideoListViewHolder(
            RowVideoListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoListViewHolder, position: Int) {
        return holder.bind(position, getItem(position))
    }
}