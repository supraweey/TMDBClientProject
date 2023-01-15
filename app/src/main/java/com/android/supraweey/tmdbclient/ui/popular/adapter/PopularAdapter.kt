package com.android.supraweey.tmdbclient.ui.popular.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.supraweey.tmdbclient.databinding.ItemPopularBinding
import com.android.supraweey.tmdbclient.domain.MovieItem
import com.android.supraweey.tmdbclient.ui.popular.viewholder.PopularViewHolder

class PopularAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList = mutableListOf<MovieItem>()
    private var onClick: (item: MovieItem) -> Unit = {}

    @SuppressLint("NotifyDataSetChanged")
    fun updateItem(items: List<MovieItem>) = apply {
        itemList = items.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemPopularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is PopularViewHolder -> {
                holder.onBind(itemList[position])
            }
        }
    }

    override fun getItemCount(): Int = itemList.count()

    fun onClick(block: (MovieItem) -> Unit) = apply {
        onClick = block
    }

}