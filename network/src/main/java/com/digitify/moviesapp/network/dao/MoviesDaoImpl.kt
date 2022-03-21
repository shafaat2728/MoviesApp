package com.digitify.moviesapp.network.dao

import com.digitify.moviesapp.domain.dao.MoviesDao
import com.digitify.moviesapp.domain.models.Movies
import com.digitify.moviesapp.network.db.MoviesDatabase
import javax.inject.Inject

class MoviesDaoImpl @Inject constructor(
    private val moviesDatabase: MoviesDatabase
) : MoviesDao {

    override suspend fun insertMoviesData(moviesEntity: List<Movies>) {
        return moviesDatabase.moviesDao().insertMoviesData(moviesEntity)
    }

    override suspend fun getMoviesList(): List<Movies> {
        return moviesDatabase.moviesDao().getMoviesList()
    }

}