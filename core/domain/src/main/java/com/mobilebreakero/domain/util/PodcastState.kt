package com.mobilebreakero.domain.util

import com.mobilebreakero.domain.entity.Podcasts
import com.mobilebreakero.domain.entity.PodcastsItem

data class PodcastState(
    val podcasts: Podcasts? = null,
    val isLoading: Boolean = false,
    val error : String? = null
)