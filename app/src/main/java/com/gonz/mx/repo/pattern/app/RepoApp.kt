package com.gonz.mx.repo.pattern.app

import android.app.Application
import com.gonz.mx.repo.pattern.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RepoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RepoApp)
            modules(
                listOf(koinAppModule, mainModule, rangeOfPokemonsModule, showDbModule, singlePokemonModule)
            )
        }
    }
}