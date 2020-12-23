package com.example.pokemons.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.pokemons.R
import com.example.pokemons.paging.PokemonsLoadingAdapter
import com.example.pokemons.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private val mainActivityViewModel by viewModel<MainActivityViewModel>()
    private val pokemonsAdapter = PokemonsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        getPokemons()
    }

    private fun setupViews() {
        pokemonsRecyclerView.adapter = pokemonsAdapter
        pokemonsRecyclerView.adapter = pokemonsAdapter.withLoadStateHeaderAndFooter(
            header = PokemonsLoadingAdapter { pokemonsAdapter.retry() },
            footer = PokemonsLoadingAdapter { pokemonsAdapter.retry() }
        )
    }

    private fun getPokemons() {
        lifecycleScope.launch {
           mainActivityViewModel.getPokemons().collectLatest {
              pokemonsAdapter.submitData(it)
          }
        }

    }
}