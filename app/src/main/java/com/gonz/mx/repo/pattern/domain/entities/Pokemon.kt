package com.gonz.mx.repo.pattern.domain.entities

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("name") val name: String,
    @SerializedName("id")   val id: Int
)