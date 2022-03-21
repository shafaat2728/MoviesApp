package com.digitify.moviesapp.di

import com.digitify.moviesapp.domain.dao.MoviesDao
import com.digitify.moviesapp.network.dao.MoviesDaoImpl
import com.digitify.moviesapp.network.db.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {
    @Provides
    @Singleton
    fun provideMoviesDao(moviesDatabase: MoviesDatabase): MoviesDao {
        return MoviesDaoImpl(moviesDatabase)
    }
}