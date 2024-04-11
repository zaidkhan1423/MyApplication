package com.zaid.myapplication.core.di

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .header("XApiKey", "1")
            .build()
        return chain.proceed(newRequest)
    }
}