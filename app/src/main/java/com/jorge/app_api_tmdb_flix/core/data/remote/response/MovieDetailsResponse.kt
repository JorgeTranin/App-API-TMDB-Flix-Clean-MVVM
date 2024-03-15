package com.jorge.app_api_tmdb_flix.core.data.remote.response

import com.jorge.app_api_tmdb_flix.core.data.util.BASE_URL_MOVIES_IMAGE
import com.jorge.app_api_tmdb_flix.core.data.util.SIZE_MOVIE_MEDIUM
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieDetails

data class MovieDetailsResponse(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun MovieDetailsResponse.toMovieDetailsModel(): MovieDetails {
    return MovieDetails(
        id = this.id,
        title = this.title,
        urlImage = "$BASE_URL_MOVIES_IMAGE$SIZE_MOVIE_MEDIUM${this.backdrop_path}",
        overview = this.overview,
    )
}

