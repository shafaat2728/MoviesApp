package com.digitify.moviesapp.network.repository

import com.digitify.moviesapp.domain.models.MovieDetail
import com.digitify.moviesapp.domain.repository.MovieDetailRepository
import com.digitify.moviesapp.network.remote.ApiService
import retrofit2.Response
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieDetailRepository {

    override suspend fun getMovieDetail(movieId: String): Response<MovieDetail> {
        return apiService.getMovieDetail(movieId)
    }
}