package com.android.supraweey.tmdbclient.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.android.supraweey.tmdbclient.domain.MovieItem
import java.lang.Math.max
import java.time.LocalDateTime

class MovieDataSource : PagingSource<Long, MovieItem>() {
    val STARTING_KEY = 0
    @RequiresApi(Build.VERSION_CODES.O)
    private val firstArticleCreatedTime = LocalDateTime.now()

    override fun getRefreshKey(state: PagingState<Long, MovieItem>): Long? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, MovieItem> {
        val start = params.key ?: STARTING_KEY
//        val range = start.until(start + params.loadSize)
        TODO("Not yet implemented")
    }

    private fun ensureValidKey(key: Int) = kotlin.math.max(STARTING_KEY, key)
}