package com.mobilebreakero.data.repoimpl

import com.mobilebreakero.data.mapper.CuratedPodcastsMapper
import com.mobilebreakero.data.remote.PodcastApi
import com.mobilebreakero.domain.entity.CuratedPodcastsModel
import com.mobilebreakero.domain.repo.CuratedPodcastsRepo
import com.mobilebreakero.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CuratedPodcastsRepoImpl @Inject constructor(private val api: PodcastApi, private val mapper: CuratedPodcastsMapper) : CuratedPodcastsRepo{

    override suspend fun getCuratedPodcasts(): Flow<Resource<CuratedPodcastsModel>> = flow {
        emit(Resource.Loading())
        try {
            val curatedPodcasts = api.getCuratedPodcasts("SDFKduyJ47r")
            if (curatedPodcasts.isSuccessful){
                curatedPodcasts.body()?.let {
                    emit(Resource.Success(mapper.fromRemotePodcastsToPodcastsModel(it)))
                }
            }
        }catch (e: Exception){
            emit(Resource.Error(e.toString()))
        }
    }

}