package com.gonz.mx.repo.pattern.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface PokemonDao {

    @Query("SELECT * FROM PersistentPokemon WHERE id = :id")
    fun getPokemonById(id: Int): Flowable<Pokemon>

    @Query("SELECT * FROM PersistentPokemon")
    fun getAllPokemons() : Flowable<List<Pokemon>>

    @Query("SELECT count(*) FROM PersistentPokemon")
    fun countPokemonsInDb(): Flowable<Int>

    @Query("DELETE FROM PersistentPokemon")
    fun deleteAllPokemons(): Completable

    @Insert
    fun insertPokemon(p: Pokemon) : Completable
}