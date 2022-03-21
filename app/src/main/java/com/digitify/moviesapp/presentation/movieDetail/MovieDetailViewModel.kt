package com.digitify.moviesapp.presentation.movieDetail

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitify.moviesapp.domain.models.MovieDetail
import com.digitify.moviesapp.domain.use_cases.MovieDetailUseCase
import com.digitify.moviesapp.domain.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: MovieDetailUseCase
) : ViewModel() {


    val movieDetailData = MutableLiveData<MovieDetail>()
    val isLoading = ObservableBoolean()
    val isError = MutableLiveData<String>()

     fun getMovieDetail(movieId: String) {
        movieDetailUseCase(movieId).onEach { result ->
            when (result) {
                is State.Success -> {
                    result.wrapperData?.let {
                        movieDetailData.value = it
                    }
                    isLoading.set(false)
                }
                is State.Error -> {
                    isLoading.set(false)
                    isError.value = result.serverError ?: "An unexpected error occurred"
                }
                is State.Loading -> {
                    isLoading.set(true)
                }

            }
        }.launchIn(viewModelScope)
    }


}