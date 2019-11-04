package com.gonz.mx.repo.pattern.di.koin

import com.gonz.mx.repo.pattern.domain.gateways.PokemonGateway
import com.gonz.mx.repo.pattern.domain.repos.PokemonRepository
import com.gonz.mx.repo.pattern.domain.usecases.DeleteAllPokemonsInDbUseCase
import com.gonz.mx.repo.pattern.domain.usecases.GetAllPokemonsInDbUseCase
import com.gonz.mx.repo.pattern.domain.usecases.GetRangeOfPokemonsUseCase
import com.gonz.mx.repo.pattern.domain.usecases.GetSinglePokemonUseCase
import com.gonz.mx.repo.pattern.handlers.NetworkHandler
import com.gonz.mx.repo.pattern.network.PokeApi
import com.gonz.mx.repo.pattern.room.PokemonDatabase
import com.gonz.mx.repo.pattern.utils.Utils
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val koinAppModule: Module = module {
    // Pokemon client
    single {
        Retrofit
            .Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PokeApi::class.java)
    }

    // Pokemon database dao
    single {
        PokemonDatabase
            .getInstance(get())
            .pokemonDao()
    }

    // Handlers
    single {
        NetworkHandler(get())
    }

    // Gateways
    single<PokemonGateway> {
        PokemonRepository(get(), get(), get())
    }

    // Use cases
    single {
        GetSinglePokemonUseCase(get())
    }


    single {
        GetAllPokemonsInDbUseCase(get())
    }


    single {
        DeleteAllPokemonsInDbUseCase(get())
    }

    single {
        GetRangeOfPokemonsUseCase(get())
    }
}