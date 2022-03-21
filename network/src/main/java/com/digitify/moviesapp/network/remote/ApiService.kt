package com.digitify.moviesapp.network.remote

import com.digitify.moviesapp.domain.models.MovieDetail
import com.digitify.moviesapp.domain.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("movie/popular")
    suspend fun getMovies(
    ): Response<MoviesModel>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: String
    ): Response<MovieDetail>

}
