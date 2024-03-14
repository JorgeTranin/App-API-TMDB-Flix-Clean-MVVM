package com.jorge.app_api_tmdb_flix.core.data.remote.response

data class MoviesPopularResponse(
    val page: Int,
    val results: List<MoviePopularResult>,
    val total_pages: Int,
    val total_results: Int
)