package com.digitify.moviesapp.presentation.movies

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitify.moviesapp.domain.models.Movies
import com.digitify.moviesapp.domain.use_cases.MoviesUseCase
import com.digitify.moviesapp.domain.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {


    val moviesList = MutableLiveData<List<Movies>>()
    private val searchMoviesList = MutableLiveData<List<Movies>>()
    val isLoading = ObservableBoolean()
    val isError = MutableLiveData<String>()

    init {
        getMovies()
    }

    private fun getMovies() {
        moviesUseCase().onEach { result ->
            when (result) {
                is State.Success -> {
                    moviesList.value = result.wrapperData.results?.sortedBy { it.id } ?: emptyList()
                    searchMoviesList.value = result.wrapperData.results ?: emptyList()
                    isLoading.set(false)
                }
                is State.DBSuccess -> {
                    moviesList.value = result.wrapperData.results?.sortedBy { it.id } ?: emptyList()
                    searchMoviesList.value = result.wrapperData.results ?: emptyList()

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

    fun onRefresh() {
        isLoading.set(true)
        getMovies()
    }

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        searchMovies(s.toString())

    }

    private fun searchMovies(text: String) {

        val allMovies = ArrayList<Movies>()

        searchMoviesList.value?.forEach { it ->
            if (it.title.isNullOrEmpty().not()) {
                if (it.title.toString().contains(text, true)) {
                    allMovies.add(it)
                }
            }
        }

        moviesList.value = allMovies ?: emptyList()
    }
}