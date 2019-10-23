package com.gonz.mx.repo.pattern.view.single.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.utils.Utils
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_single_pokemon.*
import me.sargunvohra.lib.pokekotlin.model.Pokemon
import javax.inject.Inject

class SinglePokemonActivity : AppCompatActivity(), SinglePokemonContract.View, HasAndroidInjector {

    @Inject lateinit var dispatch: DispatchingAndroidInjector<Any>
    @Inject lateinit var presenter: SinglePokemonContract.Presenter
    var pokemonId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_single_pokemon)

        pokemonId = intent.getIntExtra(Utils.SINGLE_POKEMON_INTENT_PARAMETER, 1)

        presenter.getPokemon(pokemonId)
    }

    override fun showPokemon(pokemon: Pokemon) {
        pokemonName.text = pokemon.name
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatch
}
