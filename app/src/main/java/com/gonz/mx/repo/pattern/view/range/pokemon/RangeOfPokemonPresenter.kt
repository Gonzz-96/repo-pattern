package com.gonz.mx.repo.pattern.view.range.pokemon

import com.gonz.mx.repo.pattern.domain.usecases.GetRangeOfPokemonsUseCase

class RangeOfPokemonPresenter(
    private val view: RangeOfPokemonsContract.View,
    private val usecase: GetRangeOfPokemonsUseCase
) : RangeOfPokemonsContract.Presenter {

    override fun getRangeOfPokemons(init: Int, end: Int) {
        usecase(init, end, view::showPokemon)
    }
}