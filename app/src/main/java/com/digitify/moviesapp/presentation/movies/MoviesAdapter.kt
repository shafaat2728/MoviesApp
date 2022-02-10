package com.digitify.moviesapp.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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
            listener?.invoke(item,position)
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