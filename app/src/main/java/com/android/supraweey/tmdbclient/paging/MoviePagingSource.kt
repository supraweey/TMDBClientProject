package com.android.supraweey.tmdbclient.paging

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