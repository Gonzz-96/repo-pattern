package com.gonz.mx.repo.pattern.domain.usecases

import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import me.sargunvohra.lib.pokekotlin.model.Pokemon

class GetRangePokemonUseCase(val gateway: PokemonGateway) {

    operator fun invoke(init: Int, end: Int) {
        gateway.getRangePokemon(init, end)
    }

}