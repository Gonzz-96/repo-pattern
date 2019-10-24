package com.gonz.mx.repo.pattern.di

import com.gonz.mx.repo.pattern.view.show.db.ShowDBActivity
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = [SinglePokemonModule::class])
    abstract fun singlePokemonActivity() : SinglePokemonActivity

    @ContributesAndroidInjector(modules = [ShowBDModule::class])
    abstract fun showDbAcvitivy() : ShowDBActivity

}