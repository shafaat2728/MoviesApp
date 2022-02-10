package com.digitify.moviesapp.domain.repository

import com.digitify.moviesapp.data.dto.MovieDetail
import retrofit2.Response

interface MovieDetailRepository {
    suspend fun getMovieDetail(movieId:String) : Response<MovieDetail>
}