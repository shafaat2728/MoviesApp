package com.digitify.moviesapp.domain.use_cases

import com.digitify.moviesapp.common.State
import com.digitify.moviesapp.data.dto.MovieDetail
import com.digitify.moviesapp.data.dto.MoviesModel
import com.digitify.moviesapp.domain.repository.MovieDetailRepository
import com.digitify.moviesapp.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) {

    operator fun invoke(movieId: String): Flow<State<MovieDetail>> = flow {
        try {
            emit(State.Loading())
            val data = movieDetailRepository.getMovieDetail(movieId)
            if (data.isSuccessful) {
                emit(State.Success(data.body()!!))
            } else {
                emit(State.Error(data.message()))
            }

        } catch (e: HttpException) {
            emit(State.Error(e.message ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(State.Error("Internet connection appears to be offline"))
        }

    }

}