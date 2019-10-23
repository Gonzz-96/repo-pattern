package com.gonz.mx.repo.pattern.domain.gateways

import me.sargunvohra.lib.pokekotlin.model.Pokemon

interface PokemonGateway {
    fun getSinglePokemon(id: Int) : Pokemon
    fun getRangePokemon(init: Int, end: Int): List<Pokemon>
    fun clearDatabase()
    fun clearCache()

    // Experimental
    fun persistPokemon(pokemon: Pokemon) {}
    fun persistListOfPokemon(list: List<Pokemon>) {}
}