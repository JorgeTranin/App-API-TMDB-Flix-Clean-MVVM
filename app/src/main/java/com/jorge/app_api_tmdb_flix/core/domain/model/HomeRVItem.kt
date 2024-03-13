package com.jorge.app_api_tmdb_flix.core.domain.model

sealed class HomeRVItem{
    class Cabecalho(
        val title: String
    ): HomeRVItem()

    class Filme(
        val image: String
    ): HomeRVItem()
}
