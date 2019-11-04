package com.gonz.mx.repo.pattern.domain.usecases

import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import io.reactivex.Observable
import javax.inject.Singleton

@Singleton
class GetRangeOfPokemonsUseCase(private val gw: PokemonGateway) {

    operator fun invoke(init: Int, end: Int, success: (Pokemon) -> Unit) =
        gw.getRangeOfPokemons(init, end)
            .subscribe(success)

}