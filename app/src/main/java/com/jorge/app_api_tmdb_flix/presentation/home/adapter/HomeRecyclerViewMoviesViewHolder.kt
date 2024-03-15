package com.jorge.app_api_tmdb_flix.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieItem
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeMovieHorizontalBinding
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeMovieVerticalBinding

sealed class HomeRecyclerViewMoviesViewHolder(binding: ViewBinding, ) :
    RecyclerView.ViewHolder(binding.root) {

    class MovieVerticalViewHolder(
        private val binding: ItemHomeMovieVerticalBinding,
        private val onClick : (MovieItem.MovieVertical) -> Unit
    ) : HomeRecyclerViewMoviesViewHolder(binding) {

        fun bind(movieVertical: MovieItem.MovieVertical) {

            Glide.with(binding.ivCardFilme)
                .load(movieVertical.image)
                .centerCrop()
                .into(binding.ivCardFilme)

            onClick(movieVertical)

        }

    }

    class MovieHorizontalViewHolder(
        private val binding: ItemHomeMovieHorizontalBinding,
        private val onClick : (MovieItem.MovieHorizontal) -> Unit
    ) : HomeRecyclerViewMoviesViewHolder(binding) {

        fun bind(movieHorizontal: MovieItem.MovieHorizontal) {
            Glide.with(binding.ivCardFilme)
                .load(movieHorizontal.image)
                .into(binding.ivCardFilme)

            onClick(movieHorizontal)

        }

    }

}