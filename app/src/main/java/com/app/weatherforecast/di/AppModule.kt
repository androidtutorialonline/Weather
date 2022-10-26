package com.app.weatherforecast.di

import android.content.Context
import com.app.weatherforecast.data.RemoteDataSource
import com.app.weatherforecast.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAuthApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): ApiService {
        return remoteDataSource.buildApi(ApiService::class.java, context)
    }

}