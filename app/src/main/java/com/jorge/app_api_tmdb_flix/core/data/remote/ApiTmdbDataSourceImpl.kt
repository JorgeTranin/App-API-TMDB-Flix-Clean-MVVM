package com.jorge.app_api_tmdb_flix.core.data.remote

import com.jorge.app_api_tmdb_flix.core.data.remote.api.ApiTmdb
import com.jorge.app_api_tmdb_flix.core.data.remote.response.MoviesPopularResponse
import retrofit2.Response
import javax.inject.Inject

class ApiTmdbDataSourceImpl @Inject constructor(
    private val apiTMDB: ApiTmdb
): ApiTmdbDataSource {
    override suspend fun getMoviesPopular(): Response<MoviesPopularResponse> {
        return apiTMDB.getMoviesPopular()
    }
}