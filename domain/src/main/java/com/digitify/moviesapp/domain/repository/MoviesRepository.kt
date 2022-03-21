package com.digitify.moviesapp.domain.repository

import com.digitify.moviesapp.domain.models.MoviesModel
import retrofit2.Response

interface MoviesRepository {
    suspend fun getMovies(): Response<MoviesModel>
}