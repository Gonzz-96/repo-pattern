package com.gonz.mx.repo.pattern.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gonz.mx.repo.pattern.domain.entities.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao() : PokemonDao

    companion object {
        private var INSTANCE : PokemonDatabase? = null

        fun getInstance(context: Context) : PokemonDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

            private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                    PokemonDatabase::class.java, "Pokemon.db")
                    .build()
    }
}