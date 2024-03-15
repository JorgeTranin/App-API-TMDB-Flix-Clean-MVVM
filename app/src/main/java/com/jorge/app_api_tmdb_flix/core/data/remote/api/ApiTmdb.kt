package com.jorge.app_api_tmdb_flix.core.data.remote.api

import com.jorge.app_api_tmdb_flix.core.data.remote.response.MovieDetailsResponse
import com.jorge.app_api_tmdb_flix.core.data.remote.response.MoviesPopularResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiTmdb {

    @GET("movie/popular")
    suspend fun getMoviesPopular(): Response<MoviesPopularResponse>

    @GET("movie/top_rated")
    suspend fun getMovieesnowPlaying(): Response<MoviesPopularResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ): Response<MovieDetailsResponse>
}