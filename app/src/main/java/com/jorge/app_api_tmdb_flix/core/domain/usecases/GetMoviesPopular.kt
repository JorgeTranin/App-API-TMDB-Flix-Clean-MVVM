package com.jorge.app_api_tmdb_flix.core.domain.usecases

import com.jorge.app_api_tmdb_flix.core.data.remote.response.MoviesPopularResponse
import com.jorge.app_api_tmdb_flix.core.data.repository.ApiTmdbRepository
import com.jorge.app_api_tmdb_flix.core.domain.model.HeaderItem
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import retrofit2.Response
import javax.inject.Inject

interface GetMoviesPopular {
    suspend operator fun invoke(): MutableList<HeaderItem>
}

class GetMoviesPopularImpl @Inject constructor(
    private val repository: ApiTmdbRepository
) : GetMoviesPopular {
    override suspend fun invoke(): MutableList<HeaderItem> {
        try {
            return repository.getMoviesPopular()

        } catch (e: Exception) {
            throw e
        }
    }
}