package com.gonz.mx.repo.pattern.view.show.db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.adapter.PokemonAdapter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_show_db.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import javax.inject.Inject

class ShowDBActivity : AppCompatActivity(), ShowDBContract.View {

    val presenter: ShowDBContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_show_db)

        presenter.getPokemonsInDB { list ->
            pokemonRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@ShowDBActivity)
                adapter = PokemonAdapter(list.toMutableList())
            }
        }
    }
}
