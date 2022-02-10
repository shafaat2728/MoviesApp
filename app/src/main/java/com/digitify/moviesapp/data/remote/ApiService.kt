package com.digitify.moviesapp.data.remote

import com.digitify.moviesapp.data.dto.MovieDetail
import com.digitify.moviesapp.data.dto.MoviesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("movie/popular")
    suspend fun getMovies(
    ): Response<MoviesModel>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: String
    ): Response<MovieDetail>

}
