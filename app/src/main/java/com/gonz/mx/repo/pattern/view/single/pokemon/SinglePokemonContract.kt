package com.gonz.mx.repo.pattern.view.single.pokemon

import com.gonz.mx.repo.pattern.domain.entities.Pokemon

interface SinglePokemonContract {
    interface View {
        fun showPokemon(pokemon: Pokemon)
    }

    interface Presenter {
        fun getPokemon(id: Int)
    }
}