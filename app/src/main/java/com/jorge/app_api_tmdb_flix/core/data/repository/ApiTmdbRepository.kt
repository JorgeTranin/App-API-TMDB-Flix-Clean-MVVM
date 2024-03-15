package com.jorge.app_api_tmdb_flix.core.data.repository

import com.jorge.app_api_tmdb_flix.core.data.remote.ApiTmdbDataSource
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import javax.inject.Inject

class ApiTmdbRepository @Inject constructor(
    private val apiTmbdDataSource: ApiTmdbDataSource
) {

    suspend fun getMoviesPopular(): MutableList<MoviePopular> =
        apiTmbdDataSource.getMoviesPopular()

}