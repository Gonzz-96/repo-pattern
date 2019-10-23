package com.gonz.mx.repo.pattern.view.single.pokemon

interface SinglePokemonContract {
    interface View {

    }

    interface Presenter {
        fun getPokemon(id: Int)
    }
}