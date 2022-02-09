package com.digitify.moviesapp.domain.repository

import com.digitify.moviesapp.data.dto.MoviesModel
import retrofit2.Response

interface MoviesRepository {
    suspend fun getMovies(): Response<MoviesModel>
}