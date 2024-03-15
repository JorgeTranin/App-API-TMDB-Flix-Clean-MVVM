package com.jorge.app_api_tmdb_flix.presentation.movieDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieDetails
import com.jorge.app_api_tmdb_flix.core.domain.usecases.GetMovieDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetails: GetMovieDetails
) : ViewModel() {

    private var _movie: MutableLiveData<MovieDetails> = MutableLiveData()
    val movie: MutableLiveData<MovieDetails> = _movie


    fun getMovieDetailsVM(id: Int) {
        viewModelScope.launch {

            val movie = getMovieDetails(id)
            _movie.value = movie
        }

    }
}