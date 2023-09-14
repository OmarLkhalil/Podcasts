package com.mobilebreakero.data.repoimpl

import android.util.Log
import com.mobilebreakero.data.remote.PodcastApi
import com.mobilebreakero.domain.entity.Podcasts
import com.mobilebreakero.domain.entity.PodcastsItem
import com.mobilebreakero.domain.repo.PodcastsRepo
import com.mobilebreakero.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PodcastsRepoImpl (private val api : PodcastApi) : PodcastsRepo{

    override suspend fun getPodcasts(): Flow<Resource<Podcasts>> = flow {
        emit(Resource.Loading())
        try {
            val response = api.getPodcasts().body()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }.flowOn(Dispatchers.IO)
}