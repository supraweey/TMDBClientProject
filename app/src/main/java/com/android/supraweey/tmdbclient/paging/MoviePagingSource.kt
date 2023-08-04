package com.android.supraweey.tmdbclient.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.android.supraweey.tmdbclient.data.popular.MovieResponse
import com.android.supraweey.tmdbclient.data.popular.ResultMovieResponse
import com.android.supraweey.tmdbclient.domain.MovieDataRepository
import com.android.supraweey.tmdbclient.domain.MovieItem

//class MoviePagingSource(private val repository: MovieDataRepository) :
//    PagingSource<Int, MovieResponse>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResponse> {
//        return try {
//            val currentPage = params.key ?: 1
//            val response = repository.getMoviePopular(currentPage)
//            val data = response.
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, MovieResponse>): Int? {
//        TODO("Not yet implemented")
//    }
//}