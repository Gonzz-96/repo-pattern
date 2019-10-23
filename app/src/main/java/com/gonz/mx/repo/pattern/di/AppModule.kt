package com.gonz.mx.repo.pattern.di

import dagger.Module
import dagger.Provides
import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient

@Module
class AppModule {

    @Provides
    fun getPokemonApi() : PokeApi = PokeApiClient()

}