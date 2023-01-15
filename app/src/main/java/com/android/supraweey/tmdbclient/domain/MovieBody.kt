package com.android.supraweey.tmdbclient.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class MovieBody(
    val apiKey: String?,
    val page: Int?
) : Parcelable
