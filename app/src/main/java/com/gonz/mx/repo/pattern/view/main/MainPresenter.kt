package com.gonz.mx.repo.pattern.view.main

import com.gonz.mx.repo.pattern.domain.usecases.DeleteAllPokemonsInDbUseCase

class MainPresenter(
    private val view: MainContract.View,
    private val deleteAllPokemonsInDbUseCase: DeleteAllPokemonsInDbUseCase
) : MainContract.Presenter {

    override fun deletePokemonsFromDB() {
        deleteAllPokemonsInDbUseCase()
    }
}
