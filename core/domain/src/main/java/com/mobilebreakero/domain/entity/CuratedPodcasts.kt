package com.mobilebreakero.domain.entity

data class CuratedPodcastsModel(
    val curatedPodcasts: List<CuratedPodcastItem> = listOf(),
)


data class CuratedPodcastItem(
    val id: String = "",
    val title: String = "",
    val thumbnail: String = "",
)