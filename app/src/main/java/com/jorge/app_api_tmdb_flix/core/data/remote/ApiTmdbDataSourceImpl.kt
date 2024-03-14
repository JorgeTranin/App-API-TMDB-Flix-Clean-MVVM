package com.jorge.app_api_tmdb_flix.core.data.remote

import com.jorge.app_api_tmdb_flix.core.data.remote.api.ApiTmdb
import com.jorge.app_api_tmdb_flix.core.data.remote.response.toFilmePopularModelHorizontal
import com.jorge.app_api_tmdb_flix.core.data.remote.response.toFilmePopularModelVertical
import com.jorge.app_api_tmdb_flix.core.domain.model.HeaderItem
import javax.inject.Inject

class ApiTmdbDataSourceImpl @Inject constructor(
    private val apiTMDB: ApiTmdb
) : ApiTmdbDataSource {
    override suspend fun getMoviesPopular(): MutableList<HeaderItem>{
        val filmes = apiTMDB.getMoviesPopular()

        return if (filmes.isSuccessful) {
            val headerItem = HeaderItem(
                "Populares",
                filmes.body()?.results?.mapTo(mutableListOf()) { it.toFilmePopularModelVertical() } ?: mutableListOf()
            )
            mutableListOf (headerItem)
        } else {
            mutableListOf()
        }
    }
}