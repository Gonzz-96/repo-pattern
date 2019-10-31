package com.gonz.mx.repo.pattern.domain.usecases

import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import io.reactivex.Observable
import javax.inject.Singleton

@Singleton
class GetSinglePokemonUseCase(private val gateway: PokemonGateway) {

    operator fun invoke(id: Int) : Observable<Pokemon> = gateway.getSinglePokemon(id)

}