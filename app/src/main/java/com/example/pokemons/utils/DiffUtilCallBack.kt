package com.example.pokemons.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.pokemons.model.Pokemon

class DiffUtilCallBack: DiffUtil.ItemCallback<Pokemon>(){
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.name == newItem.name && oldItem.url == newItem.url
    }
}