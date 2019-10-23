package com.gonz.mx.repo.pattern.domain.repos

import android.util.Log
import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.model.Pokemon


class PokemonRepository(
    private val pokeClient: PokeApi
) : PokemonGateway {

    override fun getSinglePokemon(id: Int): Pokemon {
        Log.v("POKEMON", "Pokemon retrieved")
        return pokeClient.getPokemon(id)
    }

    override fun getRangePokemon(init: Int, end: Int): List<Pokemon> {
        return emptyList()
    }

    override fun clearDatabase() {

    }

    override fun clearCache() {

    }
}