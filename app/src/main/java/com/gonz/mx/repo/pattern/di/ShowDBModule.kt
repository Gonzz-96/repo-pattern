package com.gonz.mx.repo.pattern.di

import com.gonz.mx.repo.pattern.view.show.db.ShowDBContract
import com.gonz.mx.repo.pattern.view.show.db.ShowDBPresenter
import org.koin.core.module.Module
import org.koin.dsl.module

val showDbModule: Module = module {

    factory<ShowDBContract.Presenter> { (v: ShowDBContract.View) ->
        ShowDBPresenter(v, get())
    }
}