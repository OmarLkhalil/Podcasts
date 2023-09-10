package com.mobilebreakero.podcasts.di

import com.mobilebreakero.domain.repo.GenresRepo
import com.mobilebreakero.domain.usecase.GenresUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {
    @Provides
    fun getUseCase(genresRepo: GenresRepo): GenresUseCase {
        return GenresUseCase(genresRepo)
    }

}