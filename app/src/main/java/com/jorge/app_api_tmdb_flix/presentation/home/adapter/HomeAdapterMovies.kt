package com.jorge.app_api_tmdb_flix.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jorge.app_api_tmdb_flix.core.domain.model.HeaderItem
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieItem
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeMovieHorizontalBinding
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeMovieVerticalBinding


class HomeAdapterMovies(
    private val listMovies: MutableList<MovieItem>,
    private val onClickVertical: (MovieItem.MovieVertical) -> Unit,
    private val onClickHorizontal: (MovieItem.MovieHorizontal) -> Unit
) :
    RecyclerView.Adapter<HomeRecyclerViewMoviesViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HomeRecyclerViewMoviesViewHolder =
        when (viewType) {
            TIPO_HORIZONTAL -> HomeRecyclerViewMoviesViewHolder.MovieHorizontalViewHolder(
                ItemHomeMovieHorizontalBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onClickHorizontal
            )

            TIPO_VERTICAL -> HomeRecyclerViewMoviesViewHolder.MovieVerticalViewHolder(
                ItemHomeMovieVerticalBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onClickVertical
            )

            else -> throw IllegalArgumentException("Tipo de View Inválido")
        }


    override fun onBindViewHolder(holder: HomeRecyclerViewMoviesViewHolder, position: Int) {
        when (holder) {
            is HomeRecyclerViewMoviesViewHolder.MovieVerticalViewHolder -> holder.bind(listMovies[position] as MovieItem.MovieVertical)
            is HomeRecyclerViewMoviesViewHolder.MovieHorizontalViewHolder -> holder.bind(listMovies[position] as MovieItem.MovieHorizontal)
        }
    }

    override fun getItemViewType(position: Int): Int = when (listMovies[position]) {
        is MovieItem.MovieVertical -> TIPO_VERTICAL
        is MovieItem.MovieHorizontal -> TIPO_HORIZONTAL
    }


    override fun getItemCount(): Int = listMovies.size

    companion object {
        const val TIPO_VERTICAL = 1
        const val TIPO_HORIZONTAL = 0
    }
}