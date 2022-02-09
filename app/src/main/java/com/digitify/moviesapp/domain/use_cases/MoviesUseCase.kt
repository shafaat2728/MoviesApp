package com.digitify.moviesapp.domain.use_cases

import com.digitify.moviesapp.common.State
import com.digitify.moviesapp.data.dto.MoviesModel
import com.digitify.moviesapp.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {

    operator fun invoke(): Flow<State<MoviesModel>> = flow {
        try {
            emit(State.Loading())
            val data = moviesRepository.getMovies()
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