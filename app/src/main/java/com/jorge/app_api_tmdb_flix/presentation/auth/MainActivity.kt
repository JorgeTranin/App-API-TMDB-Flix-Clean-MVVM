package com.jorge.app_api_tmdb_flix.presentation.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jorge.app_api_tmdb_flix.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}