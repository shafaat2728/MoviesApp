package com.digitify.moviesapp.network.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.digitify.moviesapp.domain.dao.MoviesDao
import com.digitify.moviesapp.domain.models.Movies

@Database(entities = [Movies::class], version = 1, exportSchema = false)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}