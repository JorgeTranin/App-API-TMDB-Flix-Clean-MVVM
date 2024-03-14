package com.jorge.app_api_tmdb_flix.core.data.remote.api

import com.jorge.app_api_tmdb_flix.core.data.util.BASE_URL
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