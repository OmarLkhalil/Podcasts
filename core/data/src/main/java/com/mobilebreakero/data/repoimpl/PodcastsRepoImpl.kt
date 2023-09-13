package com.mobilebreakero.data.repoimpl

import com.mobilebreakero.data.remote.PodcastApi
import com.mobilebreakero.domain.entity.Podcasts
import com.mobilebreakero.domain.repo.PodcastsRepo

class PodcastsRepoImpl (private val api : PodcastApi) : PodcastsRepo{

    override suspend fun getPodcasts(): Podcasts {
        return api.getPodcasts()
    }
}