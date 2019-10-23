package com.gonz.mx.repo.pattern.di

import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import com.gonz.mx.repo.pattern.domain.repos.PokemonRepository
import com.gonz.mx.repo.pattern.domain.usecases.GetSinglePokemonUseCase
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonActivity
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonContract
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonPresenter
import dagger.Module
import dagger.Provides
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient

@Module
class SinglePokemonModule {

    @Provides
    fun getPresenter(
        view: SinglePokemonContract.View,
        usecase: GetSinglePokemonUseCase) : SinglePokemonContract.Presenter =
        SinglePokemonPresenter(view, usecase)

    @Provides
    fun getView(activity: SinglePokemonActivity): SinglePokemonContract.View = activity

    @Provides
    fun getUseCase(gw: PokemonGateway) : GetSinglePokemonUseCase = GetSinglePokemonUseCase(gw)

    @Provides
    fun getGateway(client: PokeApiClient) : PokemonGateway = PokemonRepository(client)
}
