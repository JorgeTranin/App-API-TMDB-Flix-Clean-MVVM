package com.jorge.app_api_tmdb_flix.presentation.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import com.jorge.app_api_tmdb_flix.core.domain.usecases.GetMoviesNowPlaying
import com.jorge.app_api_tmdb_flix.core.domain.usecases.GetMoviesPopular
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesPopular: GetMoviesPopular,
    private val getMoviesNowPlaying: GetMoviesNowPlaying,
) : ViewModel() {

    private var _listMoviesPopular: MutableLiveData<MutableList<MoviePopular>> = MutableLiveData()
    val listMoviesPopular: MutableLiveData<MutableList<MoviePopular>> = _listMoviesPopular

    private var _listMoviesNowPlaying: MutableLiveData<MutableList<MoviePopular>> = MutableLiveData()
    val listMoviesNowPlaying: MutableLiveData<MutableList<MoviePopular>> = _listMoviesNowPlaying

    fun getMovieesPopularList() {

        viewModelScope.launch {
            val movies = getMoviesPopular.invoke()
            movies.forEach {

                Log.i("moviesP", it.name.toString())
            }
            _listMoviesPopular.value = movies

        }
    }

    fun getMovieesNowPlayingList() {

        viewModelScope.launch {
            val movies = getMoviesNowPlaying.invoke()
            movies.forEach {

                Log.i("moviesNow", it.name.toString())
            }
            _listMoviesNowPlaying.value = movies

        }
    }
}