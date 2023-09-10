package com.mobilebreakero.domain.repo

import com.mobilebreakero.domain.entity.Genres

interface GenresRepo {
    suspend fun getGenres():Genres

}