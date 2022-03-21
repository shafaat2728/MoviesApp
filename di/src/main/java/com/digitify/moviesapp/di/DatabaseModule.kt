package com.digitify.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.digitify.moviesapp.network.db.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideMoviesDatabase(context: Context): MoviesDatabase = Room.databaseBuilder(context,
        MoviesDatabase::class.java,"MoviesDatabase").build()




}