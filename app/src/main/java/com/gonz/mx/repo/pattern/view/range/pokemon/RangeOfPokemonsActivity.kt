package com.gonz.mx.repo.pattern.view.range.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.adapter.PokemonAdapter
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_range_of_pokemons.*
import javax.inject.Inject

class RangeOfPokemonsActivity : AppCompatActivity(), HasAndroidInjector, RangeOfPokemonsContract.View {

    @Inject lateinit var dispatch: DispatchingAndroidInjector<Any>
    @Inject lateinit var presenter: RangeOfPokemonsContract.Presenter

    val pokemonAdapter = PokemonAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_range_of_pokemons)


        pokemonsRecyclerView.adapter = pokemonAdapter

        getRangeOfPokemons.setOnClickListener {
            pokemonAdapter.pokemonList.clear()
            pokemonAdapter.notifyDataSetChanged()
            processInputs()
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatch

    override fun showPokemon(p: Pokemon) {
        Log.v("REPO_PATTERN", p.toString())
        pokemonAdapter.pokemonList.add(p)
        pokemonAdapter.notifyDataSetChanged()
    }

    private fun processInputs() {
        val init = initOfRange.text.toString().toIntOrNull() ?: 0
        val end = endOfRange.text.toString().toIntOrNull() ?: 10

        presenter.getRangeOfPokemons(init, end)
    }
}
