package com.mobilebreakero.domain.repo

import com.mobilebreakero.domain.util.Resource
import com.mobilebreakero.domain.entity.ResultsItem
import kotlinx.coroutines.flow.Flow

interface SearchResultRepo {

    fun getResult(text: String?): Flow<Resource<List<ResultsItem?>>>
}