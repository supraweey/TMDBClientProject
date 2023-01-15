package com.android.supraweey.tmdbclient.domain

import com.android.supraweey.tmdbclient.domain.MovieBody
import com.android.supraweey.tmdbclient.domain.MovieResultItem
import kotlinx.coroutines.flow.Flow

interface MovieDataRepository{
    fun getMoviePopular(request: MovieBody): Flow<MovieResultItem>
}