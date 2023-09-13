package com.mobilebreakero.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.mobilebreakero.domain.entity.PodcastsItem
import com.mobilebreakero.home.databinding.PodcastItemBinding

internal class PodcastAdapter(
    private val context: Context
) : ListAdapter<PodcastsItem, PodcastsViewHolder>(PodcastDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastsViewHolder {
        val view = PodcastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PodcastsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PodcastsViewHolder, position: Int) {
        val item = getItem(position)
        Glide.with(context).load(item.thumbnail).into(holder.binding.podcastImage)
        holder.binding.podcastTitle.text = item.title
    }
}