package com.gonz.mx.repo.pattern.view.single.pokemon

import com.gonz.mx.repo.pattern.domain.usecases.GetSinglePokemonUseCase

class SinglePokemonPresenter(
    private val view: SinglePokemonContract.View,
    private val getSinglePokemon: GetSinglePokemonUseCase
) : SinglePokemonContract.Presenter {

    override fun getPokemon(id: Int) {
        getSinglePokemon(id, view::showPokemon)
    }
}