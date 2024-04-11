package com.zaid.myapplication.feature_main.di

import com.zaid.myapplication.feature_main.data.repository.MainRepositoryImpl
import com.zaid.myapplication.feature_main.domain.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsHomeRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository

}