package com.gonz.mx.repo.pattern.di

import android.app.Application
import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import com.gonz.mx.repo.pattern.domain.repos.PokemonRepository
import com.gonz.mx.repo.pattern.domain.usecases.GetRangePokemonUseCase
import com.gonz.mx.repo.pattern.domain.usecases.GetSinglePokemonUseCase
import com.gonz.mx.repo.pattern.network.PokeApi
import com.gonz.mx.repo.pattern.room.PokemonDao
import com.gonz.mx.repo.pattern.room.PokemonDatabase
import com.gonz.mx.repo.pattern.utils.Utils
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun getPokemonApi() : PokeApi =
        Retrofit
            .Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PokeApi::class.java)

    @Provides
    fun getPokemonDao(app: Application) : PokemonDao =
        PokemonDatabase
            .getInstance(app)
            .pokemonDao()

    @Provides
    fun getSinglePokemonUseCase(gw: PokemonGateway) : GetSinglePokemonUseCase = GetSinglePokemonUseCase(gw)

    @Provides
    fun getRangePokemonUseCase(gw: PokemonGateway) : GetRangePokemonUseCase = GetRangePokemonUseCase(gw)

    @Provides
    fun getGateway(client: PokeApi, dao: PokemonDao) : PokemonGateway = PokemonRepository(client, dao)
}