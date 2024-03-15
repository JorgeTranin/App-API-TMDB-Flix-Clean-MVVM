package com.jorge.app_api_tmdb_flix.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jorge.app_api_tmdb_flix.databinding.FragmentHomeBinding
import com.jorge.app_api_tmdb_flix.presentation.home.adapter.HomeAdapterMovie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var homeAdapterPopular: HomeAdapterMovie
    private lateinit var homeAdapterNowPlaying: HomeAdapterMovie

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
        setReciclerViewNowPlaying()
        viewModelObserver()
        getMoviesPopular()
        getMoviesNowPlaying()

    }

    private fun setReciclerView() {
        homeAdapterPopular = HomeAdapterMovie({
            Toast.makeText(requireContext(), "Show ${it.id}", Toast.LENGTH_LONG).show()
        })
        binding.rvHome.setHasFixedSize(true)
        binding.rvHome.adapter = homeAdapterPopular
    }

    private fun setReciclerViewNowPlaying() {
        homeAdapterNowPlaying = HomeAdapterMovie({
            Toast.makeText(requireContext(), "Show ${it.id}", Toast.LENGTH_LONG).show()
        })
        binding.rvHomeNowPlaying.setHasFixedSize(true)
        binding.rvHomeNowPlaying.adapter = homeAdapterNowPlaying
    }

    private fun viewModelObserver() {
        viewModel.listMoviesPopular.observe(viewLifecycleOwner) { moviesPopular ->
            homeAdapterPopular.submitList(moviesPopular)
        }
        viewModel.listMoviesNowPlaying.observe(viewLifecycleOwner) { listMoviesNowPlaying ->
            homeAdapterNowPlaying.submitList(listMoviesNowPlaying)
        }
    }

    private fun getMoviesPopular() {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getMovieesPopularList()
        }

    }

    private fun getMoviesNowPlaying() {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getMovieesNowPlayingList()
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}