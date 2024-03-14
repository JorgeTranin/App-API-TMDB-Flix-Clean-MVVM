package com.jorge.app_api_tmdb_flix.core.data.remote.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object RetrofitService {

    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_URL_MOVIES_IMAGE = "https://image.tmdb.org/t/p/"
    const val API_KEY = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMzU5NTUxZjUzYjUwOTg3ODc4M2I1OThlODQ4MzMyNSIsInN1YiI6IjY1ZGExYmE0YmVmZDkxMDE3ZDIwNDgyMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TbC-r2lkuxqe6OEqiSeX2Gl7zLlOyVgcoyIJHG664KM"
    const val SIZE_MOVIE_MEDIUM = "w780"
    @Provides
    fun provideAuthorizationInterceptor(): AuthInterceptorApiTmdb {
        return AuthInterceptorApiTmdb()
    }

    @Provides
    fun okHttpClient(
        authInterceptor: AuthInterceptorApiTmdb
    ): OkHttpClient {

        return OkHttpClient.Builder().writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(authInterceptor).build()
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun retrofitService(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): ApiTmdb {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
            .create(ApiTmdb::class.java)
    }

}