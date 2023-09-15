package com.mobilebreakero.domain.entity

import com.google.gson.annotations.SerializedName

data class SearchResult(

	@field:SerializedName("took")
	val took: Any? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("next_offset")
	val nextOffset: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("update_frequency_hours")
	val updateFrequencyHours: Int? = null,

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("description_original")
	val descriptionOriginal: String? = null,

	@field:SerializedName("listen_score_global_rank")
	val listenScoreGlobalRank: String? = null,

	@field:SerializedName("itunes_id")
	val itunesId: Int? = null,

	@field:SerializedName("explicit_content")
	val explicitContent: Boolean? = null,

	@field:SerializedName("publisher_highlighted")
	val publisherHighlighted: String? = null,

	@field:SerializedName("audio_length_sec")
	val audioLengthSec: Int? = null,

	@field:SerializedName("earliest_pub_date_ms")
	val earliestPubDateMs: Long? = null,

	@field:SerializedName("genre_ids")
	val genreIds: List<Int?>? = null,

	@field:SerializedName("listennotes_url")
	val listennotesUrl: String? = null,

	@field:SerializedName("total_episodes")
	val totalEpisodes: Int? = null,

	@field:SerializedName("title_highlighted")
	val titleHighlighted: String? = null,

	@field:SerializedName("title_original")
	val titleOriginal: String? = null,

	@field:SerializedName("rss")
	val rss: String? = null,

	@field:SerializedName("description_highlighted")
	val descriptionHighlighted: String? = null,

	@field:SerializedName("publisher_original")
	val publisherOriginal: String? = null,

	@field:SerializedName("latest_episode_id")
	val latestEpisodeId: String? = null,

	@field:SerializedName("listen_score")
	val listenScore: String? = null,

	@field:SerializedName("latest_pub_date_ms")
	val latestPubDateMs: Long? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
