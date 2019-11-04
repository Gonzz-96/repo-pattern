package com.gonz.mx.repo.pattern.di.koin

import com.gonz.mx.repo.pattern.view.main.MainContract
import com.gonz.mx.repo.pattern.view.main.MainPresenter
import org.koin.core.module.Module
import org.koin.dsl.module

val mainModule: Module = module {

    factory<MainContract.Presenter> { (view: MainContract.View) ->
        MainPresenter(view, get())
    }

}