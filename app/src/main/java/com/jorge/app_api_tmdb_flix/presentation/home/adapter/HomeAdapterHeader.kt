package com.jorge.app_api_tmdb_flix.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jorge.app_api_tmdb_flix.core.domain.model.HeaderItem
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieItem
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeTitleBinding

class HomeAdapter : ListAdapter<HeaderItem, HomeAdapter.HomeViewHolder>(DiffCallback()) {

    //var listenerVisitante: (HeaderItem) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeTitleBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class HomeViewHolder(
        private val binding: ItemHomeTitleBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(headerItem: HeaderItem) {
            /*
                        binding.cardVisitante.setOnClickListener {
                            listenerVisitante(visitante)
                        }

             */

            val list : MutableList<MovieItem> = mutableListOf()
            headerItem.movieItem.forEach{
                list.add(it)
            }

            binding.run {
                txtTitleItem.text = headerItem.title
                rvFilmes.setHasFixedSize(true)
                rvFilmes.adapter = HomeAdapterMovies(list)
            }

        }
    }

}

class DiffCallback : DiffUtil.ItemCallback<HeaderItem>() {
    override fun areItemsTheSame(oldItem: HeaderItem, newItem: HeaderItem) = oldItem == newItem
    override fun areContentsTheSame(oldItem: HeaderItem, newItem: HeaderItem) =
        oldItem.title == newItem.title

}