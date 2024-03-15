package com.jorge.app_api_tmdb_flix.core.data.remote

import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular

interface ApiTmdbDataSource {
    suspend fun getMoviesPopular(): MutableList<MoviePopular>
}