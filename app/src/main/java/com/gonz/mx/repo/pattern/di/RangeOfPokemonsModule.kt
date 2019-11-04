package com.gonz.mx.repo.pattern.di

import com.gonz.mx.repo.pattern.domain.usecases.GetRangeOfPokemonsUseCase
import com.gonz.mx.repo.pattern.view.range.pokemon.RangeOfPokemonPresenter
import com.gonz.mx.repo.pattern.view.range.pokemon.RangeOfPokemonsActivity
import com.gonz.mx.repo.pattern.view.range.pokemon.RangeOfPokemonsContract
import dagger.Module
import dagger.Provides

@Module
class RangeOfPokemonsModule {

    @Provides
    fun getView(activity: RangeOfPokemonsActivity) : RangeOfPokemonsContract.View = activity

    @Provides
    fun getPresenter(view: RangeOfPokemonsContract.View,
                     usecase: GetRangeOfPokemonsUseCase) : RangeOfPokemonsContract.Presenter = RangeOfPokemonPresenter(view, usecase)

}