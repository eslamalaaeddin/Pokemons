package com.example.pokemons.network

import com.example.pokemons.model.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("pokemon")
    suspend fun getResponse(
        @Query("limit") loadSize: Int = 0,
        @Query("next") next: String? = null,
        @Query("previous") previous: String? = null,
    ): Response
}