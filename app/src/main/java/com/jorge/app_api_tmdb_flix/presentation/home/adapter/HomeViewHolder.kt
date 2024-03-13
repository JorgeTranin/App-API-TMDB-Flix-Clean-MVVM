package com.jorge.app_api_tmdb_flix.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.jorge.app_api_tmdb_flix.core.domain.model.HomeRVItem
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeBinding
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeTitleBinding

sealed class HomeViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class CabecalhoViewHolder(
        private val binding: ItemHomeTitleBinding
    ) : HomeViewHolder(binding){
        fun bind(cabecalho: HomeRVItem.Cabecalho){
            binding.txtTitleItem.text = cabecalho.title
        }
    }
    class Filme(
        private val binding: ItemHomeBinding
    ): HomeViewHolder(binding){
        fun bind(filme: HomeRVItem.Filme){

            Glide.with(binding.ivCardFilme)
                .load(filme.image)
                .into(binding.ivCardFilme)
        }
    }
}