package com.mobilebreakero.podcasts.di

import com.mobilebreakero.data.remote.PodcastApi
import com.mobilebreakero.data.repoimpl.GenresRepImp
import com.mobilebreakero.domain.repo.GenresRepo
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
    fun provideRepo(apiService: PodcastApi): GenresRepo {
        return GenresRepImp(apiService)
    }
}