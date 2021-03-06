package com.gonz.mx.repo.pattern.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.view.range.pokemon.RangeOfPokemonsActivity
import com.gonz.mx.repo.pattern.view.show.db.ShowDBActivity
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonActivity
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), View.OnClickListener, HasAndroidInjector, MainContract.View {

    @Inject lateinit var dispatch: DispatchingAndroidInjector<Any>
    @Inject lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
    }

    private fun initializeViews() {
        singlePokemon.setOnClickListener(this)
        showDb.setOnClickListener(this)
        clearDb.setOnClickListener(this)
        rangePokemon.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.singlePokemon -> getSinglePokemon()
            R.id.showDb -> showPokemonsFromDB()
            R.id.clearDb -> clearDbActivity()
            R.id.rangePokemon -> rangeOfPokemons()
        }
    }

    /**
     *
     */
    private fun getSinglePokemon() {
        startActivity(Intent(this, SinglePokemonActivity::class.java))
    }

    private fun showPokemonsFromDB() {
        startActivity(Intent(this, ShowDBActivity::class.java))
    }

    private fun clearDbActivity() {
        presenter.deletePokemonsFromDB()
        Toast.makeText(this, "DB Cleared!", Toast.LENGTH_SHORT).show()
    }

    private fun rangeOfPokemons() {
        startActivity(Intent(this, RangeOfPokemonsActivity::class.java))
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatch
}
