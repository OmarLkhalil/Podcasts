package com.mobilebreakero.domain.repo

import com.mobilebreakero.domain.entity.Genres
import com.mobilebreakero.domain.entity.GenresItem

interface GenresRepo {
    suspend fun getGenres(): List<GenresItem?>?

}