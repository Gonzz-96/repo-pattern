package com.gonz.mx.repo.pattern.view.single.pokemon

import me.sargunvohra.lib.pokekotlin.model.Pokemon

interface SinglePokemonContract {
    interface View {
        fun showPokemon(pokemon: Pokemon)
    }

    interface Presenter {
        fun getPokemon(id: Int)
    }
}