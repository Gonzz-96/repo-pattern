package com.gonz.mx.repo.pattern.view.range.pokemon

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.adapter.PokemonAdapter
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import kotlinx.android.synthetic.main.activity_range_of_pokemons.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RangeOfPokemonsActivity : AppCompatActivity(), RangeOfPokemonsContract.View {

    val presenter: RangeOfPokemonsContract.Presenter by inject { parametersOf(this) }

    val pokemonAdapter = PokemonAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_range_of_pokemons)


        pokemonsRecyclerView.adapter = pokemonAdapter

        getRangeOfPokemons.setOnClickListener {
            pokemonAdapter.pokemonList.clear()
            pokemonAdapter.notifyDataSetChanged()
            processInputs()
        }
    }

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
