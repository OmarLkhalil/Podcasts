package com.mobilebreakero.domain.usecase

import com.mobilebreakero.domain.repo.PodcastsRepo
import javax.inject.Inject

class PodcastsUseCase (private val podcastsRepo: PodcastsRepo) {

    suspend  fun execute()  = podcastsRepo.getPodcasts()

}