package com.gonz.mx.repo.pattern.view.range.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class RangeOfPokemonsActivity : AppCompatActivity(), HasAndroidInjector, RangeOfPokemonsContract.View {

    @Inject lateinit var dispatch: DispatchingAndroidInjector<Any>
    @Inject lateinit var presenter: RangeOfPokemonsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_range_of_pokemons)

        presenter.getRangeOfPokemons(30, 40)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatch

    override fun showPokemon(p: Pokemon) {
        Log.v("REPO_PATTERN", p.toString())
    }
}
