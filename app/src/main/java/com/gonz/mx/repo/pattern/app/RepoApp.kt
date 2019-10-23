package com.gonz.mx.repo.pattern.app

import android.app.Application
import com.gonz.mx.repo.pattern.di.DaggerAppComponent

class RepoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .setApplication(this)
            .build()
            .inject(this)
    }
}