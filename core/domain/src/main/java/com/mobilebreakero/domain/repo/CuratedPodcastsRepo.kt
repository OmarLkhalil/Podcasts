package com.mobilebreakero.domain.repo

import com.mobilebreakero.domain.entity.CuratedPodcastsModel
import com.mobilebreakero.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface CuratedPodcastsRepo {
    suspend fun getCuratedPodcasts(): Flow<Resource<CuratedPodcastsModel>>
}