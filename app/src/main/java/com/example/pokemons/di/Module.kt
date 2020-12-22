package com.example.pokemons.di

import com.example.pokemons.network.Api
import com.example.pokemons.network.RetrofitInstance
import com.example.pokemons.repository.Repository
import com.example.pokemons.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val apiModule = module {
    fun provideApi(): Api {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance()
        return retrofitInstance.create(Api::class.java)
    }
    single { provideApi() }
}

val repositoryModule = module { single { Repository(get()) } }

val mainActivityViewModel = module { viewModel { MainActivityViewModel(get()) } }