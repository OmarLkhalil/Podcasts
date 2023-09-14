package com.mobilebreakero.podcasts.di

import com.mobilebreakero.data.mapper.CuratedPodcastsMapper
import com.mobilebreakero.data.remote.PodcastApi
import com.mobilebreakero.data.repoimpl.CuratedPodcastsRepoImpl
import com.mobilebreakero.data.repoimpl.GenresRepImp
import com.mobilebreakero.data.repoimpl.PodcastsRepoImpl
import com.mobilebreakero.domain.repo.CuratedPodcastsRepo
import com.mobilebreakero.domain.repo.GenresRepo
import com.mobilebreakero.domain.repo.PodcastsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideGenresRepo(apiService: PodcastApi): GenresRepo {
        return GenresRepImp(apiService)
    }

    @Provides
    @Singleton
    fun providePodcastRepo(apiService: PodcastApi): PodcastsRepo {
        return PodcastsRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideCuratedPodcastRepo(apiService: PodcastApi, mapper: CuratedPodcastsMapper): CuratedPodcastsRepo {
        return CuratedPodcastsRepoImpl(apiService, mapper)
    }

}