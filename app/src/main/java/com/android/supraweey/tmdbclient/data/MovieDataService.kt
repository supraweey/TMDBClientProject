package com.android.supraweey.tmdbclient.data

import com.android.supraweey.tmdbclient.data.popular.MovieRequest
import com.android.supraweey.tmdbclient.data.popular.MovieResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataService {
    @GET("movie/popular")
    suspend fun getMoviePopular(@Query("api_key") apiKey: String, @Query("page") page: Int): MovieResponse
}