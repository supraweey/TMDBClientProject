package com.android.supraweey.tmdbclient.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.supraweey.tmdbclient.domain.MovieBody
import com.android.supraweey.tmdbclient.domain.MovieItem
import com.android.supraweey.tmdbclient.domain.MoviePopularUseCase
import com.android.supraweey.tmdbclient.domain.MovieResultItem
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class PopularViewModel(private val popularUseCase: MoviePopularUseCase) : ViewModel() {
    private val _popularMovieList = LiveEvent<List<MovieItem>>()
    val popularMovieList: LiveData<List<MovieItem>>
        get() = _popularMovieList

    private val _isError = LiveEvent<Boolean>()
    val isError: LiveData<Boolean>
        get() = _isError

    fun executePopular(movieBody :MovieBody) {
        viewModelScope.launch {
            popularUseCase.execute(movieBody)
                .onStart { }
                .catch {
                    _isError.value = true }
                .collect {
                    onGetPopularList(it)
                }
        }
    }

    private fun onGetPopularList(movieResultItem: MovieResultItem) {
        movieResultItem.results?.let {
            if (it.isNotEmpty()) {
                _popularMovieList.value = it
            }
        }

    }
}