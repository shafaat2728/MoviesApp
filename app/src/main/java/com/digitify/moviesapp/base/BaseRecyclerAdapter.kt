package com.digitify.moviesapp.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.digitify.moviesapp.domain.models.Movies

abstract class BaseRecyclerAdapter<T : Any, VB : ViewDataBinding> :
    ListAdapter<T,BaseRecyclerAdapter.Companion.BaseViewHolder<VB>>(BaseItemCallback<T>()) {


    var listener: ((view: View, item: T, position: Int) -> Unit)? = null
    fun clearItems(){
        currentList.clear()
        notifyDataSetChanged()
    }


    companion object {
        class BaseViewHolder<VB : ViewBinding>(val binding: VB) :
            RecyclerView.ViewHolder(binding.root)

        class BaseItemCallback<T : Any> : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.toString() == newItem.toString()

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder<VB>(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            getLayout(),
            parent,
            false
        )
    )

    override fun getItemCount() = this.currentList.size

    abstract fun getLayout(): Int


}