package com.android.supraweey.tmdbclient.ui.popular.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.supraweey.tmdbclient.databinding.ItemPopularBinding
import com.android.supraweey.tmdbclient.domain.IMG_W500
import com.android.supraweey.tmdbclient.domain.MovieItem
import com.bumptech.glide.Glide

class PopularViewHolder(var view: ItemPopularBinding):ViewHolder(view.root) {
    var onClick:(movieItem: MovieItem) -> Unit = {}

    fun onBind(item: MovieItem){
        view.apply {
            Glide.with(this.root.context)
                .load(IMG_W500+item.backdropPath)
                .into(imgBackdrop)
            tvPopularTitle.text = item.originalTitle
            tvPopularDate.text = item.releaseDate
            tvVoteAverage.text = item.voteAverage.toString()
            itemView.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }
}