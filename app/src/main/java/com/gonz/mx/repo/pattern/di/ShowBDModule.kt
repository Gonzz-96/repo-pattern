package com.gonz.mx.repo.pattern.di

import com.gonz.mx.repo.pattern.domain.usecases.GetAllPokemonsInDbUseCase
import com.gonz.mx.repo.pattern.view.show.db.ShowDBActivity
import com.gonz.mx.repo.pattern.view.show.db.ShowDBContract
import com.gonz.mx.repo.pattern.view.show.db.ShowDBPresenter
import dagger.Module
import dagger.Provides

@Module
class ShowBDModule {

    @Provides
    fun getView(activity: ShowDBActivity) : ShowDBContract.View = activity

    @Provides
    fun getPresenter(
        v: ShowDBContract.View,
        useCase: GetAllPokemonsInDbUseCase
    ) : ShowDBContract.Presenter = ShowDBPresenter(v, useCase)
}