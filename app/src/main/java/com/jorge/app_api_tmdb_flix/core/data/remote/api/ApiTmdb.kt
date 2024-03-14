package com.jorge.app_api_tmdb_flix.core.data.remote.api

import com.jorge.app_api_tmdb_flix.core.data.remote.response.MoviesPopularResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiTmdb {

    @GET("movie/popular")
    suspend fun getMoviesPopular() : Response<MoviesPopularResponse>
}