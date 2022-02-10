package com.digitify.moviesapp.presentation.movieDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.digitify.moviesapp.R
import com.digitify.moviesapp.databinding.FragmentMovieDetailBinding
import com.digitify.moviesapp.databinding.FragmentMoviesBinding
import com.digitify.moviesapp.presentation.movies.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    lateinit var binding: FragmentMovieDetailBinding
    private val viewModel: MovieDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel



        return binding.root
    }

}