package com.gonz.mx.repo.pattern.domain.gateways

import io.reactivex.Observable
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import io.reactivex.Flowable
import java.util.*

interface PokemonGateway {
    fun getSinglePokemon(id: Int) : Observable<Pokemon>
    fun getAllPokemonsInDb() : Observable<List<Pokemon>>
    fun clearDatabase()
    fun clearCache()

    // Experimental
    fun persistPokemon(pokemon: Pokemon) {}
    fun persistListOfPokemon(list: List<Pokemon>) {}
}