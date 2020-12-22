package com.example.pokemons.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemons.R
import com.example.pokemons.model.Pokemon
import kotlinx.android.synthetic.main.pokemon_item_layout.view.*

class PokemonsAdapter(private var pokemons: List<Pokemon>) :
    RecyclerView.Adapter<PokemonsAdapter.PokemonsHolder>() {

    inner class PokemonsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(pokemon: Pokemon) {
            Glide.with(itemView.context).load(pokemon.url).into(itemView.pokemonImageView)
            itemView.pokemonNameTextView.text = pokemon.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item_layout, parent, false)

        return PokemonsHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: PokemonsHolder, position: Int) {
        val pokemon = pokemons[holder.adapterPosition]
        holder.bind(pokemon)
    }
}