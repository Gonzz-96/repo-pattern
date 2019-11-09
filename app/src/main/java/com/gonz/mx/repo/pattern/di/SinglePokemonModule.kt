package com.gonz.mx.repo.pattern.di

import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonContract
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonPresenter
import org.koin.core.module.Module
import org.koin.dsl.module

val singlePokemonModule: Module = module {

    factory<SinglePokemonContract.Presenter> { (v: SinglePokemonContract.View) ->
        SinglePokemonPresenter(v, get())
    }

}