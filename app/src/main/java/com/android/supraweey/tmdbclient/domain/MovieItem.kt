package com.android.supraweey.tmdbclient.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class MovieItem(
    val posterPath: String?,
    val adult: Boolean?,
    val overview: String?,
    val releaseDate: String?,
    val genreIds: List<String>?,
    val id: String?,
    val originalTitle: String?,
    val originalLanguage: String?,
    val title: String?,
    val backdropPath: String?,
    val popularity: BigDecimal?,
    val voteCount: BigDecimal?,
    val video: Boolean?,
    val voteAverage: BigDecimal?
) : Parcelable
