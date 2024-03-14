package com.jorge.app_api_tmdb_flix.core.domain.model

data class HeaderItem(
    val title: String? = "",
    val movieItem: MutableList<MovieItem.MovieVertical> = mutableListOf()
)
