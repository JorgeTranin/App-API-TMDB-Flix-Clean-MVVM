package com.jorge.app_api_tmdb_flix.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jorge.app_api_tmdb_flix.core.domain.model.HeaderItem
import com.jorge.app_api_tmdb_flix.core.domain.model.Movie
import com.jorge.app_api_tmdb_flix.databinding.FragmentHomeBinding
import com.jorge.app_api_tmdb_flix.presentation.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    private var homeAdapter: HomeAdapter = HomeAdapter()

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
        loadData()
    }


    private fun setReciclerView() {
        binding.rvHome.setHasFixedSize(true)
        binding.rvHome.adapter = homeAdapter

        binding.rvHome.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }


    private fun loadData() {
        val headerMovies = getTitles()
        val popularMovies = getMovies()
        homeAdapter.submitList(headerMovies)

    }

    private fun getTitles(): MutableList<HeaderItem> {
        return mutableListOf(
            HeaderItem("title"),
            HeaderItem("title"),
            HeaderItem("title")
        )
    }

    private fun getMovies(): List<Movie> {
        return listOf(
            Movie("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"),
            Movie("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"),
            Movie("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"),
            Movie("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"),
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}