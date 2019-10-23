package com.gonz.mx.repo.pattern.domain.gateways

import com.gonz.mx.repo.pattern.domain.entities.Pokemon

interface PokemonGateway {
    fun getSinglePokemon(id: Int, l: (Pokemon) -> Unit)
    fun getRangePokemon(init: Int, end: Int)
    fun clearDatabase()
    fun clearCache()

    // Experimental
    fun persistPokemon(pokemon: Pokemon) {}
    fun persistListOfPokemon(list: List<Pokemon>) {}
}