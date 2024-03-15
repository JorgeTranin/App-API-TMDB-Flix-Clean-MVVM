package com.jorge.app_api_tmdb_flix.core.domain.usecases

import com.jorge.app_api_tmdb_flix.core.data.repository.ApiTmdbRepository
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieDetails
import javax.inject.Inject

interface GetMovieDetails {
    suspend operator fun invoke(id: Int): MovieDetails
}
class GetMovieDetailsImpl @Inject constructor(
    private val repository: ApiTmdbRepository
): GetMovieDetails{
    override suspend fun invoke(id: Int): MovieDetails {
        try {
            return repository.getMovieDetails(id)
        } catch (e: Exception){
            throw e
        }
    }

}