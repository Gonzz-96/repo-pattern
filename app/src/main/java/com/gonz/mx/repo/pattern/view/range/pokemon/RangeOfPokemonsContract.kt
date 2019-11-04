package com.gonz.mx.repo.pattern.view.range.pokemon

import com.gonz.mx.repo.pattern.domain.entities.Pokemon

interface RangeOfPokemonsContract {
    interface View {
        fun showPokemon(p: Pokemon)
    }
    interface Presenter {
        fun getRangeOfPokemons(init: Int, end: Int)
    }
}