package com.jorge.app_api_tmdb_flix.presentation.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jorge.app_api_tmdb_flix.R
import com.jorge.app_api_tmdb_flix.databinding.FragmentMovieDetailsBinding


class MovieDetailsFragment : Fragment() {
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding: FragmentMovieDetailsBinding get() = _binding!!
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
        val data = bundle?.getInt("movieID")

        binding.txtTitleMovie.text = data.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}