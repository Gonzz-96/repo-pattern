package com.gonz.mx.repo.pattern.di

import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = [SinglePokemonModule::class])
    abstract fun singlePokemonActivity() : SinglePokemonActivity

}