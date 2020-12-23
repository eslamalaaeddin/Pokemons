package com.example.pokemons.paging

import androidx.paging.PagingSource
import com.example.pokemons.model.Pokemon
import com.example.pokemons.network.Api
import retrofit2.HttpException
import java.io.IOException

class PokemonsPagingSource(private val api: Api): PagingSource<String, Pokemon>() {
    override suspend fun load(params: LoadParams<String>): LoadResult<String, Pokemon> {
        return try {
            val response = api.getResponse(loadSize = params.loadSize)
            val pokemons = response.results.orEmpty()
            LoadResult.Page(
                pokemons,
                response.previous,
                response.next
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override val keyReuseSupported: Boolean = true

}