package com.gonz.mx.repo.pattern.di

import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import com.gonz.mx.repo.pattern.domain.repos.PokemonRepository
import com.gonz.mx.repo.pattern.domain.usecases.GetAllPokemonsInDbUseCase
import com.gonz.mx.repo.pattern.domain.usecases.GetSinglePokemonUseCase
import com.gonz.mx.repo.pattern.network.PokeApi
import com.gonz.mx.repo.pattern.room.PokemonDao
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonActivity
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonContract
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonPresenter
import dagger.Module
import dagger.Provides

@Module
class SinglePokemonModule {

    @Provides
    fun getPresenter(view: SinglePokemonContract.View,
                     useCase: GetSinglePokemonUseCase) : SinglePokemonContract.Presenter =
        SinglePokemonPresenter(view, useCase)

    @Provides
    fun getView(activity: SinglePokemonActivity): SinglePokemonContract.View = activity
}
