package com.android.supraweey.tmdbclient.data.popular

import com.android.supraweey.tmdbclient.domain.MovieItem
import com.android.supraweey.tmdbclient.domain.MovieResultItem
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class MovieResponse(
    @SerializedName("page") val page: Int?,
    @SerializedName("results") val results: List<ResultMovieResponse>?,
    @SerializedName("total_results") val totalResults: BigDecimal?,
    @SerializedName("total_pages") val totalPages: BigDecimal?
)

data class ResultMovieResponse(
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("genre_ids") val genreIds: List<String>?,
    @SerializedName("id") val id: String?,
    @SerializedName("original_title") val originalTitle: String?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("popularity") val popularity: BigDecimal?,
    @SerializedName("vote_count") val voteCount: BigDecimal?,
    @SerializedName("video") val video: Boolean?,
    @SerializedName("vote_average") val voteAverage: BigDecimal?
)

fun MovieResponse.mapToDomain() =
    MovieResultItem(
        page = page,
        results = results?.map { it.mapToDomain() },
        totalResults = totalResults,
        totalPages = totalPages
    )

fun ResultMovieResponse.mapToDomain() =
    MovieItem(
        posterPath = posterPath,
        adult = adult,
        overview = overview,
        releaseDate = releaseDate,
        genreIds = genreIds,
        id = id,
        originalTitle = originalTitle,
        originalLanguage = originalLanguage,
        title = title,
        backdropPath = backdropPath,
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        voteAverage = voteAverage
    )