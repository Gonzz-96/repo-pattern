package com.gonz.mx.repo.pattern.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "PersistentPokemon")
data class Pokemon(
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int
)