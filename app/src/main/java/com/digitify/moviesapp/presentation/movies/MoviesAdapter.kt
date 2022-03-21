package com.digitify.moviesapp.presentation.movies

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.digitify.moviesapp.R
import com.digitify.moviesapp.base.BaseRecyclerAdapter
import com.digitify.moviesapp.common.checkCurrentYear
import com.digitify.moviesapp.databinding.ItemMoviesBinding
import com.digitify.moviesapp.domain.models.Movies
import javax.inject.Inject

class MoviesAdapter @Inject constructor() :
    BaseRecyclerAdapter<Movies,ItemMoviesBinding>() {

    override fun getLayout() = R.layout.item_movies


    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<ItemMoviesBinding>,
        position: Int
    ) {
        val binding=holder.binding
        val model=currentList[position]
        binding.model = model
        binding.executePendingBindings()

        if (model.release_date.checkCurrentYear()) {
            binding.tvMovieYear.setTextColor(
                ContextCompat.getColor(
                    binding.tvMovieYear.context,
                    R.color.color_red
                )
            )
            binding.tvMovieYear.setTypeface(null, Typeface.BOLD);
        } else {
            binding.tvMovieYear.setTextColor(
                ContextCompat.getColor(
                    binding.tvMovieYear.context,
                    R.color.black
                )
            )
            binding.tvMovieYear.setTypeface(null, Typeface.NORMAL);
        }

        holder.itemView.setOnClickListener {
            listener?.invoke(binding.root,model, position)
        }
    }


}