package com.mobilebreakero.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilebreakero.domain.entity.Podcasts
import com.mobilebreakero.domain.usecase.PodcastsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val podcastsUseCase: PodcastsUseCase
) : ViewModel() {

    private val podcasts: MutableStateFlow<Podcasts?> = MutableStateFlow(null)
    val _podcasts: StateFlow<Podcasts?> = podcasts

    fun fetchPodcasts() {
        viewModelScope.launch {
            try {
                val list = podcastsUseCase.execute();
                podcasts.value = list;
            } catch (e: Exception) {
                Log.e("HomeViewModelException", e.message.toString())
                throw e;
            }
        }
    }
}