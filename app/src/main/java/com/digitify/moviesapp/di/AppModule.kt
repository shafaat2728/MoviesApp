package com.digitify.moviesapp.di

import android.app.Application
import android.content.Context
import com.digitify.moviesapp.common.Constants
import com.digitify.moviesapp.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }


    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(ApiHttpClient().getHTTPClient())
            .build()
            .create(ApiService::class.java)
    }



}