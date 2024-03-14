package com.jorge.app_api_tmdb_flix.core.data.remote

import com.jorge.app_api_tmdb_flix.core.data.remote.response.MoviesPopularResponse
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import retrofit2.Response

interface ApiTmdbDataSource {
    suspend fun getMoviesPopular() : List<MoviePopular>
}