package com.mobilebreakero.data.remote

import com.mobilebreakero.domain.entity.Genres
import retrofit2.http.GET
import retrofit2.http.Query

interface PodcastApi {
    @GET("/genres")
    suspend fun getGenres(@Query("X-ListenAPI-Key")apiKey:String= "28aede4c183c4d58b08680d5eaead2c9")
    : Genres
}