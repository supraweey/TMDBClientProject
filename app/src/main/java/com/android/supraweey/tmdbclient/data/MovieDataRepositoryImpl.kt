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
    override fun getMoviePopular(page: Int): Flow<MovieResultItem> =
        object : BaseService<MovieResponse, MovieResultItem>(networkable) {
            override suspend fun callApi(): MovieResponse = service.getMoviePopular("355f6974adc97c0a921460912410fc00", page ?: 1)

            override fun mapper(from: MovieResponse): MovieResultItem = from.mapToDomain()

        }.execute()
}