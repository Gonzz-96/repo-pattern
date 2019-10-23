package com.gonz.mx.repo.pattern.domain.usecases

import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway

class GetSinglePokemonUseCase(private val gateway: PokemonGateway) {

    operator fun invoke(id: Int, l: (Pokemon) -> Unit) {
        gateway.getSinglePokemon(id, l)
    }

}