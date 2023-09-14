package com.mobilebreakero.data.dto

import com.google.gson.annotations.SerializedName

data class CuratedPodcasts(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("podcasts")
	val podcasts: List<CuratedPodcastsItem> ,

	@field:SerializedName("source_domain")
	val sourceDomain: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("pub_date_ms")
	val pubDateMs: Long? = null,

	@field:SerializedName("source_url")
	val sourceUrl: String? = null,

	@field:SerializedName("listennotes_url")
	val listennotesUrl: String? = null
)

data class Extraa(

	@field:SerializedName("amazon_music_url")
	val amazonMusicUrl: String? = null,

	@field:SerializedName("google_url")
	val googleUrl: String? = null,

	@field:SerializedName("spotify_url")
	val spotifyUrl: String? = null,

	@field:SerializedName("wechat_handle")
	val wechatHandle: String? = null,

	@field:SerializedName("patreon_handle")
	val patreonHandle: String? = null,

	@field:SerializedName("twitter_handle")
	val twitterHandle: String? = null,

	@field:SerializedName("instagram_handle")
	val instagramHandle: String? = null,

	@field:SerializedName("url3")
	val url3: String? = null,

	@field:SerializedName("url1")
	val url1: String? = null,

	@field:SerializedName("url2")
	val url2: String? = null,

	@field:SerializedName("facebook_handle")
	val facebookHandle: String? = null,

	@field:SerializedName("linkedin_url")
	val linkedinUrl: String? = null,

	@field:SerializedName("youtube_url")
	val youtubeUrl: String? = null
)

data class LookingForC(

	@field:SerializedName("cross_promotion")
	val crossPromotion: Boolean? = null,

	@field:SerializedName("sponsors")
	val sponsors: Boolean? = null,

	@field:SerializedName("guests")
	val guests: Boolean? = null,

	@field:SerializedName("cohosts")
	val cohosts: Boolean? = null
)

data class CuratedPodcastsItem(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("update_frequency_hours")
	val updateFrequencyHours: Int? = null,

	@field:SerializedName("listen_score_global_rank")
	val listenScoreGlobalRank: String? = null,

	@field:SerializedName("explicit_content")
	val explicitContent: Boolean? = null,

	@field:SerializedName("itunes_id")
	val itunesId: Int? = null,

	@field:SerializedName("audio_length_sec")
	val audioLengthSec: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("title")
	val title: String ,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("is_claimed")
	val isClaimed: Boolean? = null,

	@field:SerializedName("rss")
	val rss: String? = null,

	@field:SerializedName("extra")
	val extra: Extraa? = null,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String,

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("earliest_pub_date_ms")
	val earliestPubDateMs: Long? = null,

	@field:SerializedName("genre_ids")
	val genreIds: List<Int?>? = null,

	@field:SerializedName("listennotes_url")
	val listennotesUrl: String? = null,

	@field:SerializedName("total_episodes")
	val totalEpisodes: Int? = null,

	@field:SerializedName("looking_for")
	val lookingFor: LookingForC? = null,

	@field:SerializedName("latest_episode_id")
	val latestEpisodeId: String? = null,

	@field:SerializedName("listen_score")
	val listenScore: String? = null,

	@field:SerializedName("publisher")
	val publisher: String? = null,

	@field:SerializedName("latest_pub_date_ms")
	val latestPubDateMs: Long? = null
)
