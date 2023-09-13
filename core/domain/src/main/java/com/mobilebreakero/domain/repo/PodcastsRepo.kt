package com.mobilebreakero.domain.repo

import com.mobilebreakero.domain.entity.Podcasts

interface PodcastsRepo {
    suspend fun getPodcasts(): Podcasts
}