package com.android.supraweey.tmdbclient.domain

import android.os.Parcelable
import com.android.supraweey.tmdbclient.data.popular.ResultMovieResponse
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class MovieResultItem(
    val page: Int?,
    val results: List<MovieItem>?,
    val totalResults: BigDecimal?,
    val totalPages: BigDecimal?
) : Parcelable
