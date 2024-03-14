package com.jorge.app_api_tmdb_flix.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jorge.app_api_tmdb_flix.core.domain.model.HeaderItem
import com.jorge.app_api_tmdb_flix.core.domain.model.MovieItem
import com.jorge.app_api_tmdb_flix.databinding.FragmentHomeBinding
import com.jorge.app_api_tmdb_flix.presentation.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

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
        //loadData()
        getMoviesPopular()
        viewModelObserver()

    }

    private fun setReciclerView() {
        binding.rvHome.setHasFixedSize(true)
        binding.rvHome.adapter = homeAdapter
        binding.rvHome.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
    private fun viewModelObserver(){
        viewModel.listMoviesPopular.observe(viewLifecycleOwner){ moviesPopular ->
            homeAdapter.submitList(moviesPopular)
        }
    }
    private fun getMoviesPopular() {
        viewModel.getMovieesPopularList()

    }


    private fun loadData() {
        val headerMovies = getTitles()
        val popularMovies = getMovies()
        homeAdapter.submitList(headerMovies)

    }

    private fun getTitles(): MutableList<HeaderItem> {
        return mutableListOf(
            HeaderItem("title", getMovies()),
            HeaderItem("title", getMoviesHorizontal())
        )

    }

    private fun getMovies(): MutableList<MovieItem> {
        return mutableListOf(
            MovieItem.MovieVertical("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"),
            MovieItem.MovieVertical("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"),
            MovieItem.MovieVertical("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"),
            MovieItem.MovieVertical("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"),
            MovieItem.MovieVertical("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"),
            MovieItem.MovieVertical("https://www.themoviedb.org/t/p/w1280/opifTi4YVvqMJkDpMCi2mjwE77B.jpg"),
        )
    }

    private fun getMoviesHorizontal(): MutableList<MovieItem> {
        return mutableListOf(
            MovieItem.MovieHorizontal("https://cdn.pixabay.com/photo/2024/02/23/19/37/squirrel-8592682_1280.jpg"),
            MovieItem.MovieHorizontal("https://cdn.pixabay.com/photo/2024/02/23/19/37/squirrel-8592682_1280.jpg"),
            MovieItem.MovieHorizontal("https://cdn.pixabay.com/photo/2024/02/23/19/37/squirrel-8592682_1280.jpg"),
            MovieItem.MovieHorizontal("https://cdn.pixabay.com/photo/2024/02/23/19/37/squirrel-8592682_1280.jpg"),
            MovieItem.MovieHorizontal("https://cdn.pixabay.com/photo/2024/02/23/19/37/squirrel-8592682_1280.jpg"),
            MovieItem.MovieHorizontal("https://cdn.pixabay.com/photo/2024/02/23/19/37/squirrel-8592682_1280.jpg"),

            )
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}