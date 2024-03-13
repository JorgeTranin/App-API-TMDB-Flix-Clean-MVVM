package com.jorge.app_api_tmdb_flix.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jorge.app_api_tmdb_flix.R
import com.jorge.app_api_tmdb_flix.core.domain.model.HomeRVItem
import com.jorge.app_api_tmdb_flix.databinding.FragmentHomeBinding
import com.jorge.app_api_tmdb_flix.presentation.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeAdapter = HomeAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setReciclerView()
    }

    private fun setReciclerView(){
        binding.rvHome.setHasFixedSize(true)
        binding.rvHome.adapter = homeAdapter

        val lista = getData()
        homeAdapter.setLista(lista)
    }

    private fun getData(): MutableList<HomeRVItem>{
        val lista = mutableListOf<HomeRVItem>()
        lista.add(HomeRVItem.Cabecalho("Filmes Recentes"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))
        lista.add(HomeRVItem.Cabecalho("Filmes Populares"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))
        lista.add(HomeRVItem.Filme("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"))

        return lista
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}