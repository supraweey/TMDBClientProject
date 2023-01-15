package com.android.supraweey.tmdbclient.data

import com.android.supraweey.tmdbclient.data.popular.MovieResponse
import com.android.supraweey.tmdbclient.data.popular.mapToData
import com.android.supraweey.tmdbclient.data.popular.mapToDomain
import com.android.supraweey.tmdbclient.domain.MovieBody
import com.android.supraweey.tmdbclient.domain.MovieDataRepository
import com.android.supraweey.tmdbclient.domain.MovieResultItem
import com.android.supraweey.tmdbclient.network.Networkable
import kotlinx.coroutines.flow.Flow

class MovieDataRepositoryImpl(
    private val networkable: Networkable,
    private val service: MovieDataService
) : MovieDataRepository {
    override fun getMoviePopular(request: MovieBody): Flow<MovieResultItem> =
        object : BaseService<MovieResponse, MovieResultItem>(networkable) {
            override suspend fun callApi(): MovieResponse = request.mapToData()
                .let { service.getMoviePopular(it.apiKey ?: "", it.page ?: 1) }

            override fun mapper(from: MovieResponse): MovieResultItem = from.mapToDomain()

        }.execute()
}