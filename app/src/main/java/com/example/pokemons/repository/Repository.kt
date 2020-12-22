package com.example.pokemons.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemons.helper.Resource
import com.example.pokemons.model.Pokemon
import com.example.pokemons.model.Response
import com.example.pokemons.network.Api
import retrofit2.http.GET

class Repository(private val api: Api) {
        suspend fun getPokemons(offset: Int, limit: Int): List<Pokemon> = api.getResponse(offset, limit).results.orEmpty()
}