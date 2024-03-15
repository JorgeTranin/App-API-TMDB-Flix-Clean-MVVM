package com.jorge.app_api_tmdb_flix.presentation.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.jorge.app_api_tmdb_flix.R
import com.jorge.app_api_tmdb_flix.databinding.FragmentMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding: FragmentMovieDetailsBinding get() = _binding!!

    private val viewModel: MovieDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        val id = bundle?.getInt("movieID")

        vmObserver()
        if (id != null){
            getMovieDetails(id)
        }


    }

    private fun vmObserver(){
        viewModel.movie.observe(viewLifecycleOwner){movie ->
            Glide.with(binding.ivMovie).load(movie.urlImage).into(binding.ivMovie)
            binding.txtTitleMovie.text = movie.title
            binding.txtDescription.text = movie.overview

        }
    }
    private fun getMovieDetails(id: Int) {
        lifecycleScope.launch {
            viewModel.getMovieDetailsVM(id)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}