package com.example.pokemons.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemons.R
import com.example.pokemons.model.Pokemon
import com.example.pokemons.utils.DiffUtilCallBack
import kotlinx.android.synthetic.main.pokemon_item_layout.view.*

private const val TAG = "PokemonsPagedAdapter"
class PokemonsAdapter(): PagingDataAdapter<Pokemon, PokemonsAdapter.PokemonViewHolder>(DiffUtilCallBack()){

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let { pokemon ->
            holder.bind(pokemon)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item_layout, parent, false)

        return PokemonViewHolder(view)
    }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(pokemon: Pokemon) {

            pokemon.url = "https://pokeres.bastionbot.org/images/pokemon/${
                pokemon.url.orEmpty().substring(33, pokemon.url.orEmpty().toCharArray().size - 1)
            }.png"

            Glide.with(itemView.context).load(pokemon.url).into(itemView.pokemonImageView)
            itemView.pokemonNameTextView.text = pokemon.name
            itemView.pokemonCounterTextView.text = adapterPosition.toString()
        }
    }
}