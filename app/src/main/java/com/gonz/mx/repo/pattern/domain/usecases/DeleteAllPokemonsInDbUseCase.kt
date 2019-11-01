package com.gonz.mx.repo.pattern.domain.usecases

import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import javax.inject.Singleton

@Singleton
class DeleteAllPokemonsInDbUseCase(private val gateway: PokemonGateway) {

    operator fun invoke() {
        return gateway.clearDatabase()
    }
}