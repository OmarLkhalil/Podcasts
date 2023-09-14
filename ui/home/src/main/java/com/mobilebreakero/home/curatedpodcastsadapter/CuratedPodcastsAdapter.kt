package com.mobilebreakero.home.curatedpodcastsadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.mobilebreakero.domain.entity.CuratedPodcastItem
import com.mobilebreakero.home.databinding.PodcastItemBinding

internal class CuratedPodcastsAdapter(private val context: Context): ListAdapter<CuratedPodcastItem, CuratedPodcastsViewHolder>(CuratedPodcastDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuratedPodcastsViewHolder {
        val view = PodcastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CuratedPodcastsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CuratedPodcastsViewHolder, position: Int) {
       val item = getItem(position)
        holder.binding.podcastTitle.text = item.title
        Glide.with(context).load(item.thumbnail).into(holder.binding.podcastImage)
    }
}