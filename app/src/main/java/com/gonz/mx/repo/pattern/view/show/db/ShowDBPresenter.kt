package com.gonz.mx.repo.pattern.view.show.db

import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import com.gonz.mx.repo.pattern.domain.usecases.GetAllPokemonsInDbUseCase

class ShowDBPresenter(
    private val view: ShowDBContract.View,
    private val getAllPokemonsInDbUseCase: GetAllPokemonsInDbUseCase
) : ShowDBContract.Presenter {

    override fun getPokemonsInDB(callback: (List<Pokemon>) -> Unit) {
        getAllPokemonsInDbUseCase(callback)
    }
}