package com.gonz.mx.repo.pattern.app

import android.app.Application
import com.gonz.mx.repo.pattern.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
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
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatch
}