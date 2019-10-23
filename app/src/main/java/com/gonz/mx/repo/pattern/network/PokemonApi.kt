package com.gonz.mx.repo.pattern.network

import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonApi {

    @GET("pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int) : Single<Pokemon>
}