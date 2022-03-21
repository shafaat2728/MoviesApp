package com.digitify.moviesapp.domain.use_cases

import com.digitify.moviesapp.domain.dao.MoviesDao
import com.digitify.moviesapp.domain.models.MoviesModel
import com.digitify.moviesapp.domain.repository.MoviesRepository
import com.digitify.moviesapp.domain.utils.State
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class MoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val moviesDao: MoviesDao
) {

    operator fun invoke(): Flow<State<MoviesModel>> = flow {
        try {
            val moviesDb = moviesDao.getMoviesList()
            if (moviesDb.isNullOrEmpty().not()) {
                emit(State.DBSuccess(MoviesModel(moviesDb)))
            }
            emit(State.Loading())
            kotlinx.coroutines.delay(3000)

            val data = moviesRepository.getMovies()
            if (data.isSuccessful) {
                emit(State.Success(data.body()!!))
                data.body()?.results?.let { moviesDao.insertMoviesData(it) }

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