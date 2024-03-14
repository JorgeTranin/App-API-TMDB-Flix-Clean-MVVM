package com.jorge.app_api_tmdb_flix.presentation.home.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieItem
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeMovieHorizontalBinding
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeMovieVerticalBinding
import java.lang.IllegalArgumentException
class HomeAdapterMovies : RecyclerView.Adapter<HomeRecyclerViewMoviesViewHolder>(){

    private var lista = listOf<MovieItem>()

    fun setData(listaToSet: MutableList<MovieItem>) {
        this.lista = listaToSet
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewMoviesViewHolder =
        when (viewType) {
            TIPO_HORIZONTAL -> HomeRecyclerViewMoviesViewHolder.MovieVerticalViewHolder(
                ItemHomeMovieVerticalBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            TIPO_VERTICAL -> HomeRecyclerViewMoviesViewHolder.MovieHorizontalViewHolder(
                ItemHomeMovieHorizontalBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Tipo de View Inválido")
        }


    override fun onBindViewHolder(holder: HomeRecyclerViewMoviesViewHolder, position: Int) {
        when (holder) {
            is HomeRecyclerViewMoviesViewHolder.MovieVerticalViewHolder -> holder.bind(lista[position] as MovieItem.MovieVertical)
            is HomeRecyclerViewMoviesViewHolder.MovieHorizontalViewHolder -> holder.bind(lista[position] as MovieItem.MovieHorizontal)
        }
    }

    override fun getItemViewType(position: Int): Int = when (lista[position]) {
        is MovieItem.MovieHorizontal -> TIPO_HORIZONTAL
        is MovieItem.MovieVertical -> TIPO_VERTICAL
    }


    override fun getItemCount(): Int = lista.size

    companion object {
        const val TIPO_VERTICAL = 0
        const val TIPO_HORIZONTAL = 1
    }
}