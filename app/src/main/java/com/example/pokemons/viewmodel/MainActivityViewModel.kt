package com.example.pokemons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.pokemons.helper.Resource
import com.example.pokemons.model.Pokemon
import com.example.pokemons.repository.Repository
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: Repository): ViewModel() {
    fun getPokemonsLiveData(offset: Int, limit: Int)= liveData {
        val data = repository.getPokemons(offset, limit)
        val pokemons = mutableListOf<Pokemon>()
        for (pokemon in data) {
            pokemon.url = "https://pokeres.bastionbot.org/images/pokemon/${
                pokemon.url.orEmpty().substring(33, pokemon.url.orEmpty().toCharArray().size - 1)
            }.png"
            pokemons.add(pokemon)
        }
        emit(pokemons)
    }

}