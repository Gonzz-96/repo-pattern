package com.gonz.mx.repo.pattern.view.show.db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gonz.mx.repo.pattern.R
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ShowDBActivity : AppCompatActivity(), ShowDBContract.View, HasAndroidInjector {

    @Inject lateinit var dispatch: DispatchingAndroidInjector<Any>
    @Inject lateinit var presenter: ShowDBContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_db)

        presenter.getPokemonsInDB {

        }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatch
}
