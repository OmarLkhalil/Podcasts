package com.mobilebreakero.data.repoimpl

import com.mobilebreakero.data.remote.PodcastApi
import com.mobilebreakero.domain.entity.Genres
import com.mobilebreakero.domain.entity.GenresItem
import com.mobilebreakero.domain.repo.GenresRepo

class GenresRepImp(private val apiService: PodcastApi) : GenresRepo
{
    override suspend fun getGenres(): List<GenresItem?>? {
        return apiService.getGenres()
    }

}