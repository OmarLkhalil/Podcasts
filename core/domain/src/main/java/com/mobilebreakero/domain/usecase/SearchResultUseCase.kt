package com.mobilebreakero.domain.usecase

import com.mobilebreakero.domain.entity.ResultsItem
import com.mobilebreakero.domain.repo.SearchResultRepo
import com.mobilebreakero.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class SearchResultUseCase(private val searchResultRepo: SearchResultRepo) {
    fun invoke(text: String?): Flow<Resource<List<ResultsItem?>>> = searchResultRepo.getResult(text)
}