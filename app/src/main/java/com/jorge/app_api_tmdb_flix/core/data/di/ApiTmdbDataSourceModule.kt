package com.jorge.app_api_tmdb_flix.core.data.di

import com.jorge.app_api_tmdb_flix.core.data.remote.ApiTmdbDataSource
import com.jorge.app_api_tmdb_flix.core.data.remote.ApiTmdbDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ApiTmdbDataSourceModule {

    @Binds
    fun binddataSourceTmdb(dataSource: ApiTmdbDataSourceImpl) : ApiTmdbDataSource
}