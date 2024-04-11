package com.zaid.myapplication.feature_main.di

import com.zaid.myapplication.feature_main.data.MainApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideMainApiService(retrofit: Retrofit): MainApiService =
        retrofit.create(MainApiService::class.java)

}