package com.mobilebreakero.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mobilebreakero.domain.entity.PodcastsItem


internal class PodcastDiffUtil : DiffUtil.ItemCallback<PodcastsItem>() {

    override fun areItemsTheSame(oldItem: PodcastsItem, newItem: PodcastsItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PodcastsItem, newItem: PodcastsItem): Boolean =
        oldItem == newItem
}
