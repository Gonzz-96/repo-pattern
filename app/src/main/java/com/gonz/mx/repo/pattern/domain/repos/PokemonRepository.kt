package com.gonz.mx.repo.pattern.domain.repos

import android.util.Log
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import com.gonz.mx.repo.pattern.network.PokeApi
import com.gonz.mx.repo.pattern.room.PokemonDao
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class PokemonRepository(
    private val pokeClient: PokeApi, private val pokemonDao: PokemonDao
) : PokemonGateway {

    private val cachedPokemons: MutableList<Pokemon> = mutableListOf()

    override fun getSinglePokemon(id: Int) : Observable<Pokemon> =
        pokemonDao
            .getPokemonById(id)
            .mergeWith(pokeClient.getPokemon(id))
            .doOnNext { persistPokemon(it) }
            .toObservable()

    override fun clearDatabase() {
        pokemonDao.deleteAllPokemons()
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    override fun clearCache() {
        cachedPokemons.clear()
    }

    override fun persistPokemon(pokemon: Pokemon) {
        pokemonDao
            .insertPokemon(pokemon)
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    override fun getAllPokemonsInDb() : Flowable<List<Pokemon>> =
        pokemonDao.getAllPokemons()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun pokemonWithIdIsCached(id: Int) : Pokemon? {
        val filteredList = cachedPokemons.filter { it.id == id }
        return if(filteredList.size == 1) filteredList.first() else null
    }
}