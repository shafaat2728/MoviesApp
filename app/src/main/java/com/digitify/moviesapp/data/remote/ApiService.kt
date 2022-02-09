package com.digitify.moviesapp.data.remote

import com.digitify.moviesapp.data.dto.MoviesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") apiKey: String
    ): Response<MoviesModel>

}
