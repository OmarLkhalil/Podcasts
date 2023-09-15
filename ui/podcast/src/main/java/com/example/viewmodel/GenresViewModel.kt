package com.example.viewmodel

import androidx.lifecycle.ViewModel
import com.mobilebreakero.domain.usecase.GenresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenresViewModel  @Inject constructor(
    private val genresUseCase: GenresUseCase,
) : ViewModel(){

    suspend fun getGenresList() = genresUseCase.invoke()

}