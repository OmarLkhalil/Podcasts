package com.mobilebreakero.data.remote

import com.mobilebreakero.data.dto.CuratedPodcasts
import com.mobilebreakero.domain.entity.Genres
import com.mobilebreakero.domain.entity.Podcasts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PodcastApi {

    @GET("genres")
    suspend fun getGenres(): Genres

    @GET("best_podcasts")
    suspend fun getPodcasts(): Response<Podcasts>

    @GET("curated_podcasts/{id}")
    suspend fun getCuratedPodcasts(@Path("id") id: String): Response<CuratedPodcasts>

}