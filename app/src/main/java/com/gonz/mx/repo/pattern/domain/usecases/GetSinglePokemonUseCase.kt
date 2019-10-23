package com.gonz.mx.repo.pattern.domain.usecases

import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import me.sargunvohra.lib.pokekotlin.model.Pokemon

class GetSinglePokemonUseCase(val gateway: PokemonGateway) {

    operator fun invoke(id: Int) : Pokemon = gateway.getSinglePokemon(id)

}