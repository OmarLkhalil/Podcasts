package com.mobilebreakero.domain.entity

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Genres(

	@field:SerializedName("genres")
	val genres: List<GenresItem?>? = null
) : Parcelable

@Parcelize
data class GenresItem(

	@field:SerializedName("parent_id")
	val parentId: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable
