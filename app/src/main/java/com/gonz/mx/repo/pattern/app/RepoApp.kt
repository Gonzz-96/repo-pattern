package com.gonz.mx.repo.pattern.app

import android.app.Application
import com.gonz.mx.repo.pattern.di.DaggerAppComponent
import com.gonz.mx.repo.pattern.di.koinAppModule
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
            androidContext(this@RepoApp)
            modules(koinAppModule)
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatch
}