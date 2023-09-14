package com.mobilebreakero.data.mapper

import com.mobilebreakero.data.dto.CuratedPodcasts
import com.mobilebreakero.data.dto.CuratedPodcastsItem
import com.mobilebreakero.domain.entity.CuratedPodcastItem
import com.mobilebreakero.domain.entity.CuratedPodcastsModel
import javax.inject.Inject

class CuratedPodcastsMapper @Inject constructor(){

   fun fromRemotePodcastsToPodcastsModel(obj: CuratedPodcasts): CuratedPodcastsModel {
        return CuratedPodcastsModel(
            curatedPodcasts = mapToCuratedPodcast(obj.podcasts),
        )
    }
    private fun mapToCuratedPodcast(obj : List<CuratedPodcastsItem>): List<CuratedPodcastItem>{
        return obj.map {
            CuratedPodcastItem(
                id = it.id,
                title = it.title,
                thumbnail = it.thumbnail,
            )
        }
    }
}