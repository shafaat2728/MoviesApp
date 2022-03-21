
package com.digitify.moviesapp.di

import com.digitify.moviesapp.domain.repository.MovieDetailRepository
import com.digitify.moviesapp.domain.repository.MoviesRepository
import com.digitify.moviesapp.network.remote.ApiService
import com.digitify.moviesapp.network.repository.MovieDetailRepositoryImpl
import com.digitify.moviesapp.network.repository.MoviesRepositoryImpl
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