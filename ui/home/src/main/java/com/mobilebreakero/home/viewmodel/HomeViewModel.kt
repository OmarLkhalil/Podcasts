package com.mobilebreakero.home.viewmodel

import androidx.lifecycle.ViewModel
import com.mobilebreakero.domain.usecase.CuratedPodcastsUseCase
import com.mobilebreakero.domain.usecase.PodcastsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val podcastsUseCase: PodcastsUseCase,
    private val curatedPodcastsUseCase: CuratedPodcastsUseCase
) : ViewModel() {

    suspend fun getPodcasts() = podcastsUseCase.invoke()
    suspend fun getCuratedPodcasts() = curatedPodcastsUseCase.invoke()
}