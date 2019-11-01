package com.gonz.mx.repo.pattern.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.view.show.db.ShowDBActivity
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonActivity
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), View.OnClickListener, HasAndroidInjector {

    @Inject lateinit var dispatch: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
    }

    private fun initializeViews() {
        singlePokemon.setOnClickListener(this)
        rangePokemon.setOnClickListener(this)
        showDb.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.singlePokemon -> getSinglePokemon()
            R.id.rangePokemon -> getRangePokemon()
            R.id.showDb -> showPokemonsFromDB()
        }
    }

    /**
     *
     */
    private fun getSinglePokemon() {
        startActivity(Intent(this, SinglePokemonActivity::class.java))
    }

    private fun getRangePokemon() {

    }

    private fun showPokemonsFromDB() {
        startActivity(Intent(this, ShowDBActivity::class.java))
    }


    private fun showSnackBar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(mainLayout, message, duration).show()
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatch
}
