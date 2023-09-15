package com.mobilebreakero.data.repoimpl

import com.mobilebreakero.data.remote.PodcastApi
import com.mobilebreakero.domain.entity.ResultsItem
import com.mobilebreakero.domain.repo.SearchResultRepo
import com.mobilebreakero.domain.util.Resource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@ActivityRetainedScoped
class SearchResultRepoImpl(
    private val apiService: PodcastApi
) : SearchResultRepo {
    override fun getResult(text: String?): Flow<Resource<List<ResultsItem?>>> = flow {
        emit(Resource.Loading())
        try {
            val data = text?.let { apiService.getSearchResult(it).body()?.results }
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}