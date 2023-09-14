package com.mobilebreakero.home.curatedpodcastsadapter

import androidx.recyclerview.widget.DiffUtil
import com.mobilebreakero.domain.entity.CuratedPodcastItem

internal class CuratedPodcastDiffUtil : DiffUtil.ItemCallback<CuratedPodcastItem>() {

    override fun areItemsTheSame(oldItem: CuratedPodcastItem, newItem: CuratedPodcastItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CuratedPodcastItem, newItem: CuratedPodcastItem): Boolean =
        oldItem == newItem
}