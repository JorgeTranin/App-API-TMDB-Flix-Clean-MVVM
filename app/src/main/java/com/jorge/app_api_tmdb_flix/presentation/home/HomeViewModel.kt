package com.jorge.app_api_tmdb_flix.presentation.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import com.jorge.app_api_tmdb_flix.core.domain.usecases.GetMoviesPopular
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesPopular: GetMoviesPopular
) : ViewModel() {

    private var _listMoviesPopular : MutableLiveData<List<MoviePopular>> = MutableLiveData()
    private var listMoviesPopular : MutableLiveData<List<MoviePopular>> = _listMoviesPopular

    fun getMovieesPopularList() {

        viewModelScope.launch {
            val movies = getMoviesPopular.invoke()

            _listMoviesPopular.value = movies


        }
    }
}