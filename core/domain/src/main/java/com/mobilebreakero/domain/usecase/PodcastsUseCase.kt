package com.mobilebreakero.domain.usecase


import com.mobilebreakero.domain.entity.Podcasts
import com.mobilebreakero.domain.entity.PodcastsItem
import com.mobilebreakero.domain.repo.PodcastsRepo
import com.mobilebreakero.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PodcastsUseCase @Inject constructor(private val podcastsRepo: PodcastsRepo) {

    suspend operator fun invoke() : Flow<Resource<Podcasts>> = podcastsRepo.getPodcasts()
}
