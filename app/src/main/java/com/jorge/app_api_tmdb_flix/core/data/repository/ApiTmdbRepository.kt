package com.jorge.app_api_tmdb_flix.core.data.repository

import com.jorge.app_api_tmdb_flix.core.data.remote.ApiTmdbDataSource
import com.jorge.app_api_tmdb_flix.core.data.remote.response.MoviesPopularResponse
import com.jorge.app_api_tmdb_flix.core.domain.model.HeaderItem
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieItem
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import retrofit2.Response
import javax.inject.Inject

class ApiTmdbRepository @Inject constructor(
    private val apiTmbdDataSource: ApiTmdbDataSource
) {

    suspend fun getMoviesPopular(): HeaderItem =
        apiTmbdDataSource.getMoviesPopular()

}