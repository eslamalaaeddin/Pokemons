package com.example.pokemons.model

data class Response(
    var count: Int? = null,
    var next: String? = null,
    var previous: String? = null,
    var results: List<Pokemon>? = null
)