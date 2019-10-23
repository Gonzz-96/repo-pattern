package com.gonz.mx.repo.pattern.domain.repos

import android.util.Log
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import com.gonz.mx.repo.pattern.network.PokeApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class PokemonRepository(
    private val pokeClient: PokeApi
) : PokemonGateway {

    private val cachedPokemons: MutableList<Pokemon> = mutableListOf()

    override fun getSinglePokemon(id: Int, l: (Pokemon) -> Unit) {

        Log.v("REPOSITORY", cachedPokemons.toString())
        var alreadyFetched = false

        // Fetching in cache
        val cachedPokemon = pokemonWithIdIsCached(id)
        cachedPokemon?.let {
            Single.just(it)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({p ->
                    l(p)
                    Log.v("REPOSITORY", "From cache")
                }, {})
            alreadyFetched = true
        }

        if(alreadyFetched) return

        val x = pokeClient.getPokemon(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                l(it)

                // Caching
                cachedPokemons.add(it)
                Log.v("REPOSITORY", "From network + ${cachedPokemons.toString()}")
            }, {})
    }

    override fun getRangePokemon(init: Int, end: Int) {

    }

    override fun clearDatabase() {

    }

    override fun clearCache() {

    }

    private fun pokemonWithIdIsCached(id: Int) : Pokemon? {
        val filteredList = cachedPokemons.filter { it.id == id }
        return if(filteredList.size == 1) filteredList.first() else null
    }
}