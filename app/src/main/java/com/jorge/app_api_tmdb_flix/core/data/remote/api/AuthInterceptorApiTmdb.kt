package com.jorge.app_api_tmdb_flix.core.data.remote.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptorApiTmdb : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val constructorrequest = chain.request().newBuilder()

        val request = constructorrequest.addHeader(
            "Authorization", RetrofitService.API_KEY
        )

        return chain.proceed(request.build())
    }
}