package com.android.supraweey.tmdbclient.data.popular

import com.android.supraweey.tmdbclient.domain.MovieBody
import com.google.gson.annotations.SerializedName

data class MovieRequest(
    @SerializedName("apiKey") val apiKey: String?,
    @SerializedName("page") val page: Int?
)

fun MovieBody.mapToData():MovieRequest = MovieRequest(
    apiKey = apiKey,
    page = page
)