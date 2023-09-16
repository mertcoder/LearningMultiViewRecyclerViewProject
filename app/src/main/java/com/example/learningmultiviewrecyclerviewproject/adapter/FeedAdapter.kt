package com.example.learningmultiviewrecyclerviewproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.learningmultiviewrecyclerviewproject.databinding.ItemImagepostBinding
import com.example.learningmultiviewrecyclerviewproject.databinding.ItemTextpostBinding
import com.example.learningmultiviewrecyclerviewproject.model.Feed

class FeedAdapter(private val dataList: List<Feed>): RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    inner class FeedViewHolder(private val binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(feed: Feed){
            when(feed){
                is Feed.ImagePost -> bindImagePost(feed)
                is Feed.TextPost -> bindTextPost(feed)
            }
        }

        private fun bindImagePost(feed: Feed.ImagePost){
            val imagepostBinding = binding as ItemImagepostBinding
            imagepostBinding.authorTextView.text = feed.author
            imagepostBinding.imagePostImageView.setImageResource(feed.image)
            imagepostBinding.descriptionTextView.text = feed.description
        }
        private fun bindTextPost(feed: Feed.TextPost){
            val textpostBindingtBinding = binding as ItemTextpostBinding
            textpostBindingtBinding.authorTextView.text = feed.author
            textpostBindingtBinding.descriptionTextView.text = feed.description
            textpostBindingtBinding.feelingTextView.text = feed.feeling
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        var binding: ViewBinding
        when(viewType){
            0 -> binding = ItemImagepostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            1 -> binding = ItemTextpostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            else -> throw IllegalArgumentException("Invalid viewType")
        }
        return FeedViewHolder(binding)
    }
    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val currentData = dataList[position]
        holder.bind(currentData)
    }

    override fun getItemViewType(position: Int): Int {
        var currentData = dataList[position]
        return when(currentData){
            is Feed.ImagePost -> 0
            is Feed.TextPost -> 1
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}