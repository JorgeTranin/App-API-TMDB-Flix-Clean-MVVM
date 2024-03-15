package com.jorge.app_api_tmdb_flix.core.data.di

import com.jorge.app_api_tmdb_flix.core.domain.usecases.GetMoviesNowPlaying
import com.jorge.app_api_tmdb_flix.core.domain.usecases.GetMoviesNowPlayingImpl
import com.jorge.app_api_tmdb_flix.core.domain.usecases.GetMoviesPopular
import com.jorge.app_api_tmdb_flix.core.domain.usecases.GetMoviesPopularImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCasesModule {

    @Binds
    fun bindGetMoviesPopular(useCaseImpl: GetMoviesPopularImpl): GetMoviesPopular

    @Binds
    fun bindGetMoviesNowPlaying(useCaseImpl: GetMoviesNowPlayingImpl): GetMoviesNowPlaying
}