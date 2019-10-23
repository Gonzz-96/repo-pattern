package com.gonz.mx.repo.pattern.domain.repos

import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.Pokemon


class PokemonRepository(
    private val pokeClient: PokeApiClient
) : PokemonGateway {

    override fun getSinglePokemon(id: Int): Pokemon =
        pokeClient.getPokemon(id)

    override fun getRangePokemon(init: Int, end: Int): List<Pokemon> {
        return emptyList()
    }

    override fun clearDatabase() {

    }

    override fun clearCache() {

    }
}