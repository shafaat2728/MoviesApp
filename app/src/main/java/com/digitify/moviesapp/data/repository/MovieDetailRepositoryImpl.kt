package com.digitify.moviesapp.data.repository

import com.digitify.moviesapp.data.dto.MovieDetail
import com.digitify.moviesapp.data.remote.ApiService
import com.digitify.moviesapp.domain.repository.MovieDetailRepository
import retrofit2.Response
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieDetailRepository {

    override suspend fun getMovieDetail(movieId: String): Response<MovieDetail> {
        return apiService.getMovieDetail(movieId)
    }
}