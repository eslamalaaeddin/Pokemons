package com.example.pokemons.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pokemons.helper.Resource
import com.example.pokemons.model.Pokemon
import com.example.pokemons.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: Repository) : ViewModel() {
    suspend fun getPokemons(): Flow<PagingData<Pokemon>> {
        return repository.getPokemons()
    }
}