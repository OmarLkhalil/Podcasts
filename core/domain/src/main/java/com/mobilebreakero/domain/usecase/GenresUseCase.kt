package com.mobilebreakero.domain.usecase


import com.mobilebreakero.domain.repo.GenresRepo

class GenresUseCase(private val genres: GenresRepo) {
   suspend operator fun  invoke() = genres.getGenres()
}