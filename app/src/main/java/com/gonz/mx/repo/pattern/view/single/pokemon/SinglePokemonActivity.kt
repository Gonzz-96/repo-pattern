package com.gonz.mx.repo.pattern.view.single.pokemon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import kotlinx.android.synthetic.main.activity_single_pokemon.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SinglePokemonActivity : AppCompatActivity(), SinglePokemonContract.View {

    val presenter: SinglePokemonContract.Presenter by inject { parametersOf(this) }
    private var pokemonId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_pokemon)

        pokemonName.setOnClickListener {
            pokemonId = singlePokemonInput.text.toString().toIntOrNull() ?: 1
            presenter.getPokemon(pokemonId)
        }
    }

    override fun showPokemon(pokemon: Pokemon) {
        pokemonName.text = pokemon.name
    }
}
