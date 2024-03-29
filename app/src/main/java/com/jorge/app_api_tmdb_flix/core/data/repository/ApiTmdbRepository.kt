package com.jorge.app_api_tmdb_flix.core.data.repository

import com.jorge.app_api_tmdb_flix.core.data.remote.ApiTmdbDataSource
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieDetails
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import javax.inject.Inject

class ApiTmdbRepository @Inject constructor(
    private val apiTmbdDataSource: ApiTmdbDataSource
) {

    suspend fun getMoviesPopular(): MutableList<MoviePopular> =
        apiTmbdDataSource.getMoviesPopular()

    suspend fun getFilmesNowPlaying(): MutableList<MoviePopular> = apiTmbdDataSource.getMoviesNowPlaying()

    suspend fun getMovieDetails(id: Int): MovieDetails = apiTmbdDataSource.getMoviesDetails(id)

}