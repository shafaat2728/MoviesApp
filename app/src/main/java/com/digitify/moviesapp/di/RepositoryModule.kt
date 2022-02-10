package com.digitify.moviesapp.di

import com.digitify.moviesapp.data.remote.ApiService
import com.digitify.moviesapp.data.repository.MovieDetailRepositoryImpl
import com.digitify.moviesapp.data.repository.MoviesRepositoryImpl
import com.digitify.moviesapp.domain.repository.MovieDetailRepository
import com.digitify.moviesapp.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(api: ApiService): MoviesRepository {
        return MoviesRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideMoviesDetailRepository(api: ApiService): MovieDetailRepository {
        return MovieDetailRepositoryImpl(api)
    }

}