package com.gonz.mx.repo.pattern.domain.repos

import android.util.Log
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import com.gonz.mx.repo.pattern.network.PokeApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class PokemonRepository(
    private val pokeClient: PokeApi
) : PokemonGateway {

    override fun getSinglePokemon(id: Int, l: (Pokemon) -> Unit) {
        Log.v("POKEMON", "Pokemon retrieved")
        val x = pokeClient.getPokemon(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(l, {})
    }

    override fun getRangePokemon(init: Int, end: Int) {

    }

    override fun clearDatabase() {

    }

    override fun clearCache() {

    }
}