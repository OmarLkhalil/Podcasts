package com.mobilebreakero.data.remote

import com.mobilebreakero.domain.entity.Genres
import com.mobilebreakero.domain.entity.Podcasts
import retrofit2.http.GET
import retrofit2.http.Query

interface PodcastApi {

    @GET("/genres")
    suspend fun getGenres(): Genres

    @GET("/best_podcasts")
    suspend fun getPodcasts(): Podcasts

}