package com.jorge.app_api_tmdb_flix.core.data.remote.response

import com.jorge.app_api_tmdb_flix.core.data.remote.api.RetrofitService
import com.jorge.app_api_tmdb_flix.core.data.util.BASE_URL_MOVIES_IMAGE
import com.jorge.app_api_tmdb_flix.core.data.util.SIZE_MOVIE_MEDIUM
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieItem

data class MoviePopularResult(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun MoviePopularResult.toFilmePopularModelHorizontal(): MovieItem {
    return MovieItem.MovieHorizontal(
        "${BASE_URL_MOVIES_IMAGE}${SIZE_MOVIE_MEDIUM}${this.backdrop_path}"
    )
}
fun MoviePopularResult.toFilmePopularModelVertical(): MovieItem {
    return MovieItem.MovieVertical(
        "${BASE_URL_MOVIES_IMAGE}${SIZE_MOVIE_MEDIUM}${this.backdrop_path}"
    )
}