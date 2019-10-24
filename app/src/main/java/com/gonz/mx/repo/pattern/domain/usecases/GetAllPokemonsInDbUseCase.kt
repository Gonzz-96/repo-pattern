package com.gonz.mx.repo.pattern.domain.usecases

import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import javax.inject.Singleton

@Singleton
class GetAllPokemonsInDbUseCase(val gateway: PokemonGateway) {

    operator fun invoke(lambda: (List<Pokemon>) -> Unit) {
        gateway.getAllPokemonsInDb(lambda)
    }

}