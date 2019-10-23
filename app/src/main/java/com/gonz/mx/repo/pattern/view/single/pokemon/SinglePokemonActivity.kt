package com.gonz.mx.repo.pattern.view.single.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.utils.Utils
import javax.inject.Inject

class SinglePokemonActivity : AppCompatActivity(), SinglePokemonContract.View {

    @Inject lateinit var presenter: SinglePokemonContract
    var pokemonId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_pokemon)

        pokemonId = intent.getIntExtra(Utils.SINGLE_POKEMON_INTENT_PARAMETER, 1)
    }
}
