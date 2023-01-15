package com.android.supraweey.tmdbclient.domain

import com.android.supraweey.tmdbclient.UseCase
import kotlinx.coroutines.flow.Flow

class MoviePopularUseCase(private val repository: MovieDataRepository): UseCase<MovieBody, MovieResultItem>() {
    override fun validateRequest(request: MovieBody): MovieBody = request

    override suspend fun executeRepo(request: MovieBody, isRetry: Boolean): Flow<MovieResultItem> = repository.getMoviePopular(request)
}