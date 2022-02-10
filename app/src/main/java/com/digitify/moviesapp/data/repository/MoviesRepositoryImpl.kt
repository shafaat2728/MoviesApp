package com.digitify.moviesapp.data.repository

import com.digitify.moviesapp.BuildConfig
import com.digitify.moviesapp.data.dto.MoviesModel
import com.digitify.moviesapp.data.remote.ApiService
import com.digitify.moviesapp.domain.repository.MoviesRepository
import retrofit2.Response
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MoviesRepository {
    override suspend fun getMovies(): Response<MoviesModel> {
        return apiService.getMovies()
    }
}