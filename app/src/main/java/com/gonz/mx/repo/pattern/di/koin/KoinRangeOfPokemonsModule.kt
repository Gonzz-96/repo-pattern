package com.gonz.mx.repo.pattern.di.koin

import com.gonz.mx.repo.pattern.view.range.pokemon.RangeOfPokemonPresenter
import com.gonz.mx.repo.pattern.view.range.pokemon.RangeOfPokemonsContract
import org.koin.core.module.Module
import org.koin.dsl.module

val rangeOfPokemonsModule: Module = module {

    factory<RangeOfPokemonsContract.Presenter> { (v: RangeOfPokemonsContract.View) ->
        RangeOfPokemonPresenter(v, get())
    }

}
