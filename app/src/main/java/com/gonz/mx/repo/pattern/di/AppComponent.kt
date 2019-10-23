package com.gonz.mx.repo.pattern.di

import android.app.Application
import com.gonz.mx.repo.pattern.app.RepoApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class
])
interface AppComponent  {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setApplication(app: Application) : Builder
        fun build() : AppComponent
    }

    fun inject(app: RepoApp)
}
