package com.jorge.app_api_tmdb_flix.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jorge.app_api_tmdb_flix.core.domain.model.HomeRVItem
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeBinding
import com.jorge.app_api_tmdb_flix.databinding.ItemHomeTitleBinding

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {

    //https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg

    private var lista = mutableListOf<HomeRVItem>()
    fun setLista (lista: MutableList<HomeRVItem>){
        this.lista = lista
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return when (viewType) {
            TIPO_TITLE -> HomeViewHolder.CabecalhoViewHolder(
                ItemHomeTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            TIPO_FILME -> HomeViewHolder.Filme(
                ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            else -> throw IllegalArgumentException("Erro")
        }
    }


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        when (holder) {
            is HomeViewHolder.CabecalhoViewHolder -> holder.bind(lista[position] as HomeRVItem.Cabecalho)
            is HomeViewHolder.Filme -> holder.bind(lista[position] as HomeRVItem.Filme)
        }
    }

    override fun getItemCount(): Int = lista.size

    override fun getItemViewType(position: Int): Int {

        return when (lista[position]) {
            is HomeRVItem.Cabecalho -> TIPO_TITLE
            is HomeRVItem.Filme -> TIPO_FILME
        }

    }

    companion object {
        const val TIPO_TITLE = 0
        const val TIPO_FILME = 1
    }

}