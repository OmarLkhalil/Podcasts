package com.mobilebreakero.domain.repo

import com.mobilebreakero.domain.entity.Podcasts
import com.mobilebreakero.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface PodcastsRepo {
    suspend fun getPodcasts(): Flow<Resource<Podcasts>>
}