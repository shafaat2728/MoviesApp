package com.digitify.moviesapp.presentation.movies

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.digitify.moviesapp.R
import com.digitify.moviesapp.common.checkCurrentYear
import com.digitify.moviesapp.data.dto.Movies
import com.digitify.moviesapp.databinding.ItemMoviesBinding
import javax.inject.Inject

class MoviesAdapter @Inject constructor() :
    ListAdapter<Movies, MoviesAdapter.ViewHolder>(DiffCallback) {

    var listener: ((item: Movies, position: Int) -> Unit)? = null


    class ViewHolder(private var binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: Movies) {
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
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemMoviesBinding.inflate(layoutInflater, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener?.invoke(item, position)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Movies>() {
        override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem.title == newItem.title
        }

    }


}