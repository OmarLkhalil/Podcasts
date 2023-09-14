package com.mobilebreakero.podcasts.di

import com.mobilebreakero.domain.repo.CuratedPodcastsRepo
import com.mobilebreakero.domain.repo.GenresRepo
import com.mobilebreakero.domain.repo.PodcastsRepo
import com.mobilebreakero.domain.usecase.CuratedPodcastsUseCase
import com.mobilebreakero.domain.usecase.GenresUseCase
import com.mobilebreakero.domain.usecase.PodcastsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Provides
    @Singleton
    fun getUseCase(genresRepo: GenresRepo): GenresUseCase {
        return GenresUseCase(genresRepo)
    }

    @Provides
    @Singleton
    fun providePodcastUseCase(podcastRepo: PodcastsRepo): PodcastsUseCase {
        return PodcastsUseCase(podcastRepo)
    }

    @Provides
    @Singleton
    fun provideCuratedPodcastUseCase(curatedPodcastRepo: CuratedPodcastsRepo): CuratedPodcastsUseCase {
        return CuratedPodcastsUseCase(curatedPodcastRepo)
    }
}