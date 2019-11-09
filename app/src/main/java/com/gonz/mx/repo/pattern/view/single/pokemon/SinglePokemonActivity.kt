package com.gonz.mx.repo.pattern.view.single.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import com.gonz.mx.repo.pattern.utils.Utils
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_single_pokemon.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import javax.inject.Inject

class SinglePokemonActivity : AppCompatActivity(), SinglePokemonContract.View {

    val presenter: SinglePokemonContract.Presenter by inject { parametersOf(this) }
    private var pokemonId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
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
