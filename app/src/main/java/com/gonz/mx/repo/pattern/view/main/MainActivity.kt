package com.gonz.mx.repo.pattern.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.utils.Utils
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
    }

    private fun initializeViews() {
        singlePokemon.setOnClickListener(this)
        rangePokemon.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.singlePokemon -> getSinglePokemon()
            R.id.rangePokemon -> getRangePokemon()
            else -> doNothingLol()
        }
    }

    /**
     *
     */
    private fun getSinglePokemon() {
        val pokemonId = singlePokemonInput.text.toString()

        if(pokemonId.isEmpty()) {
            showSnackBar("Empty input!")
            return
        }

        val i = Intent(this, SinglePokemonActivity::class.java)
        i.putExtra(Utils.SINGLE_POKEMON_INTENT_PARAMETER, pokemonId.toIntOrNull() ?: 1)
        startActivity(i)
    }

    private fun getRangePokemon() {

    }

    private fun doNothingLol() {

    }

    private fun showSnackBar(message: String) {
        Snackbar.make(mainLayout, message, Snackbar.LENGTH_SHORT).show()
    }
}