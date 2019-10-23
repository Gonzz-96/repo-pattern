package com.gonz.mx.repo.pattern.view.single.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gonz.mx.repo.pattern.R

class SinglePokemonActivity : AppCompatActivity(), SimplePokemonContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_pokemon)
    }
}
