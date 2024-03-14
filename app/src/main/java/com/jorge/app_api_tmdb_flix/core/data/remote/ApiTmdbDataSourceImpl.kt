package com.jorge.app_api_tmdb_flix.core.data.remote

import com.jorge.app_api_tmdb_flix.core.data.remote.api.ApiTmdb
import com.jorge.app_api_tmdb_flix.core.data.remote.response.toFilmePopularModel
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import javax.inject.Inject

class ApiTmdbDataSourceImpl @Inject constructor(
    private val apiTMDB: ApiTmdb
) : ApiTmdbDataSource {
    override suspend fun getMoviesPopular(): List<MoviePopular> {
        val filmes = apiTMDB.getMoviesPopular()

        return if (filmes.isSuccessful) {
            filmes.body()?.results?.map { it.toFilmePopularModel() } ?: emptyList()
        } else {
            emptyList()
        }

    }
}