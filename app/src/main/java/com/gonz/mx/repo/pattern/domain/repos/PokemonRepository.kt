package com.gonz.mx.repo.pattern.domain.repos

import android.util.Log
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import com.gonz.mx.repo.pattern.handlers.NetworkHandler
import com.gonz.mx.repo.pattern.network.PokeApi
import com.gonz.mx.repo.pattern.room.PokemonDao
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class PokemonRepository(
    private val pokeClient: PokeApi,
    private val pokemonDao: PokemonDao,
    private val networkHandler: NetworkHandler
) : PokemonGateway {

    private val cachedPokemons: MutableList<Pokemon> = mutableListOf()

    // TODO Consider Single from RxJava
    override fun getSinglePokemon(id: Int) : Observable<Pokemon> =
        Observable.create { s ->
            val cachedPokemon = pokemonWithIdIsCached(id)

            // Get from cache
            if(cachedPokemon != null) {
                Log.v("REPO_PATTERN", "From cache!")

                s.onNext(cachedPokemon)
                s.onComplete()
            } else if(networkHandler.isNetworkAvailable()) {    // Get from server
                pokeClient.getPokemon(id)
                    .toObservable()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        cachedPokemons.add(it)
                        persistPokemon(it)
                        Log.v("REPO_PATTERN", "From server!")

                        s.onNext(it)
                        s.onComplete()
                    }
            } else {    // Get from DB
                pokemonDao.getPokemonById(id)
                    .toObservable()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        cachedPokemons.add(it)
                        Log.v("REPO_PATTERN", "From DB!")

                        s.onNext(it)
                        s.onComplete()
                    }
            }
        }

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

    override fun getAllPokemonsInDb() : Observable<List<Pokemon>> =
        pokemonDao.getAllPokemons()
            .toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getRangeOfPokemons(init: Int, end: Int): Observable<Pokemon> =
        Observable.range(init, (end - init) + 1)
            .flatMap({ id -> getSinglePokemon(id) }, 10)


    private fun pokemonWithIdIsCached(id: Int) : Pokemon? {
        val filteredList = cachedPokemons.filter { it.id == id }
        return if(filteredList.size == 1) filteredList.first() else null
    }
}