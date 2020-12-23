package com.example.pokemons.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pokemons.helper.Resource
import com.example.pokemons.model.Pokemon
import com.example.pokemons.model.Response
import com.example.pokemons.network.Api
import com.example.pokemons.paging.PokemonsPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.http.GET

class Repository(private val api: Api) {

        suspend fun getPokemons(): Flow<PagingData<Pokemon>> {
               return withContext(Dispatchers.IO){
                       Pager(PagingConfig(pageSize = 5, enablePlaceholders = false)) { PokemonsPagingSource(api) }.flow
                }
        }
}