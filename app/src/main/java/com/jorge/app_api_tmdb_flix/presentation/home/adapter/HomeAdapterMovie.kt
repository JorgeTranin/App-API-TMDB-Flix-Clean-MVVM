package com.jorge.app_api_tmdb_flix.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jorge.app_api_tmdb_flix.core.domain.model.MoviePopular
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeMovieVerticalBinding

class HomeAdapterMovie(
    private val onClickMovie: (MoviePopular) -> Unit
) : ListAdapter<MoviePopular, HomeAdapterMovie.HomeAdapterMoviesViewHolder>(DiffCallbackMovies()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterMoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeMovieVerticalBinding.inflate(inflater, parent, false)
        return HomeAdapterMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapterMoviesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class HomeAdapterMoviesViewHolder(
        private val binding: ItemHomeMovieVerticalBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MoviePopular) {

            binding.run {
                Glide.with(this.ivCardFilme)
                    .load(item.movieUrl)
                    .into(ivCardFilme)

                clickMovieVertical.setOnClickListener {
                    onClickMovie(item)
                }

            }

        }
    }

}

class DiffCallbackMovies : DiffUtil.ItemCallback<MoviePopular>() {
    override fun areItemsTheSame(oldItem: MoviePopular, newItem: MoviePopular) = oldItem == newItem
    override fun areContentsTheSame(oldItem: MoviePopular, newItem: MoviePopular) =
        oldItem.name == newItem.name

}