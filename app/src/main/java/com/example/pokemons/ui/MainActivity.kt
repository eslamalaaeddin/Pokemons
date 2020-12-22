package com.example.pokemons.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pokemons.R
import com.example.pokemons.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private val mainActivityViewModel by viewModel<MainActivityViewModel>()
    private lateinit var pokemonsAdapter: PokemonsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val pokemonsLiveData = mainActivityViewModel.getPokemonsLiveData(60,20)
        pokemonsLiveData.observe(this){ pokemons ->
            pokemonsAdapter = PokemonsAdapter(pokemons)
            pokemonsRecyclerView.adapter = pokemonsAdapter
        }
    }
}