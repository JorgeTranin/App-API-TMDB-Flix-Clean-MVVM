package com.jorge.app_api_tmdb_flix.core.domain.model

sealed class MovieItem{
    class MovieVertical(
        val image: String? = "",

    ) : MovieItem()

    class MovieHorizontal(
        val image: String? = "",
        ) : MovieItem()
}
