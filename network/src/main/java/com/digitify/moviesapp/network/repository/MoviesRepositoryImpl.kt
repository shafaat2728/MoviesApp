package com.digitify.moviesapp.network.repository

import com.digitify.moviesapp.domain.models.MoviesModel
import com.digitify.moviesapp.domain.repository.MoviesRepository
import com.digitify.moviesapp.network.remote.ApiService
import retrofit2.Response
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MoviesRepository {
    override suspend fun getMovies(): Response<MoviesModel> {
        return apiService.getMovies()
    }
}