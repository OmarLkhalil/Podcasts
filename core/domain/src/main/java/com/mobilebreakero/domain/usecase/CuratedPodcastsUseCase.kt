package com.mobilebreakero.domain.usecase

import com.mobilebreakero.domain.entity.CuratedPodcastsModel
import com.mobilebreakero.domain.repo.CuratedPodcastsRepo
import com.mobilebreakero.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CuratedPodcastsUseCase @Inject constructor(private val repo: CuratedPodcastsRepo){
    suspend operator fun invoke() : Flow<Resource<CuratedPodcastsModel>> = repo.getCuratedPodcasts()
}
