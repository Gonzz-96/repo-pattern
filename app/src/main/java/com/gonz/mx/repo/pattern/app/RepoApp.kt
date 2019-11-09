package com.gonz.mx.repo.pattern.app

import android.app.Application
import com.gonz.mx.repo.pattern.BuildConfig
import com.gonz.mx.repo.pattern.di.DaggerAppComponent
import com.gonz.mx.repo.pattern.di.koin.koinAppModule
import com.gonz.mx.repo.pattern.di.koin.mainModule
import com.gonz.mx.repo.pattern.di.koin.rangeOfPokemonsModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import javax.inject.Inject

class RepoApp : Application(), HasAndroidInjector {

    @Inject lateinit var dispatch : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .setApplication(this)
            .build()
            .inject(this)

        startKoin {
            androidLogger()
            androidContext(this@RepoApp)
            modules(listOf(koinAppModule, mainModule, rangeOfPokemonsModule))
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatch
}