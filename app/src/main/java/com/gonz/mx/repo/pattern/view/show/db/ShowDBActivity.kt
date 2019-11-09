package com.gonz.mx.repo.pattern.view.show.db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.adapter.PokemonAdapter
import kotlinx.android.synthetic.main.activity_show_db.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ShowDBActivity : AppCompatActivity(), ShowDBContract.View {

    val presenter: ShowDBContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_db)

        presenter.getPokemonsInDB { list ->
            pokemonRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@ShowDBActivity)
                adapter = PokemonAdapter(list.toMutableList())
            }
        }
    }
}
