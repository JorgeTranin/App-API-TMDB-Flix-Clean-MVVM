package com.jorge.app_api_tmdb_flix.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorge.app_api_tmdb_flix.core.domain.model.HeaderItem
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import com.jorge.app_api_tmdb_flix.core.domain.usecases.GetMoviesPopular
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesPopular: GetMoviesPopular
) : ViewModel() {

    private var _listMoviesPopular: MutableLiveData<MutableList<HeaderItem>> = MutableLiveData()
    val listMoviesPopular: MutableLiveData<MutableList<HeaderItem>> = _listMoviesPopular

    fun getMovieesPopularList() {

        viewModelScope.launch {
            val movies = getMoviesPopular.invoke()
            _listMoviesPopular.value = movies

        }
    }
}