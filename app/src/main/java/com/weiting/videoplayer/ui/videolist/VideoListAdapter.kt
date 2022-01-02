package com.weiting.videoplayer.ui.videolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weiting.videoplayer.databinding.RowVideoListBinding

class VideoListAdapter(val onClickListener: OnClickListener) :
    ListAdapter<String, VideoListAdapter.VideoListViewHolder>(DiffCallback) {

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
        holder.bind(position, getItem(position))
        holder.itemView.setOnClickListener {
            onClickListener.clickListener(position, getItem(position))
        }
    }

    class OnClickListener(val clickListener: (position: Int, uri: String) -> Unit) {
        fun onClick(position: Int, uri: String) = clickListener(position, uri)
    }

}