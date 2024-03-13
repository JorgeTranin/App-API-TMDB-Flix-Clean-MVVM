package com.jorge.app_api_tmdb_flix.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jorge.app_api_tmdb_flix.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}