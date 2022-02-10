package com.digitify.moviesapp.presentation.movies

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.digitify.moviesapp.R
import com.digitify.moviesapp.common.showToast
import com.digitify.moviesapp.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MoviesFragment : Fragment() {

    @Inject
    lateinit var adapter: MoviesAdapter
    lateinit var binding: FragmentMoviesBinding
    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setRecyclerView()
        setObservers()
        return binding.root
    }

    private fun setObservers() {
        viewModel.isError.observe(viewLifecycleOwner) {
            requireContext().showToast(it)
        }
    }

    private fun setRecyclerView() {
        val spanCount =
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 3 else 2

        binding.rvMovies.layoutManager = GridLayoutManager(requireContext(), spanCount)
        binding.rvMovies.adapter = adapter
        adapter.listener = { movies, position ->
        }
    }


}