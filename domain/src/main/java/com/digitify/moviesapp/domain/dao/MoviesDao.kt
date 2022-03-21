package com.digitify.moviesapp.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.digitify.moviesapp.domain.models.Movies

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesData(moviesEntity: List<Movies>)

    @Query("SELECT * FROM moviesList")
    suspend fun getMoviesList(): List<Movies>
}