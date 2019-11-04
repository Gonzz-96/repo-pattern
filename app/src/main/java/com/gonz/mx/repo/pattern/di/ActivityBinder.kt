package com.gonz.mx.repo.pattern.di

import com.gonz.mx.repo.pattern.view.main.MainActivity
import com.gonz.mx.repo.pattern.view.range.pokemon.RangeOfPokemonsActivity
import com.gonz.mx.repo.pattern.view.show.db.ShowDBActivity
import com.gonz.mx.repo.pattern.view.single.pokemon.SinglePokemonActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity() : MainActivity

    @ContributesAndroidInjector(modules = [SinglePokemonModule::class])
    abstract fun singlePokemonActivity() : SinglePokemonActivity

    @ContributesAndroidInjector(modules = [ShowBDModule::class])
    abstract fun showDbAcvitivy() : ShowDBActivity

    @ContributesAndroidInjector(modules = [RangeOfPokemonsModule::class])
    abstract fun rangeOfPokemonsActivity() : RangeOfPokemonsActivity

}