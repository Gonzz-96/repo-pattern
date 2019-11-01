package com.gonz.mx.repo.pattern.di

import com.gonz.mx.repo.pattern.domain.usecases.DeleteAllPokemonsInDbUseCase
import com.gonz.mx.repo.pattern.view.main.MainActivity
import com.gonz.mx.repo.pattern.view.main.MainContract
import com.gonz.mx.repo.pattern.view.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun getView(main: MainActivity) : MainContract.View = main

    @Provides
    fun getPresenter(view: MainContract.View, usecase: DeleteAllPokemonsInDbUseCase) : MainContract.Presenter = MainPresenter(view, usecase)

}