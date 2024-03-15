package com.jorge.app_api_tmdb_flix.core.domain.usecases

import com.jorge.app_api_tmdb_flix.core.data.repository.ApiTmdbRepository
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import javax.inject.Inject

interface GetMoviesNowPlaying {
    suspend operator fun invoke(): MutableList<MoviePopular>
}

class GetMoviesNowPlayingImpl @Inject constructor(
    private val repository: ApiTmdbRepository
) : GetMoviesNowPlaying {
    override suspend fun invoke(): MutableList<MoviePopular> {
        try {
            return repository.getFilmesNowPlaying()

        } catch (e: Exception) {
            throw e
        }
    }
}