package com.gonz.mx.repo.pattern.view.show.db

import com.gonz.mx.repo.pattern.domain.entities.Pokemon

interface ShowDBContract {
    interface View
    interface Presenter {
        fun getPokemonsInDB(callback: (List<Pokemon>) -> Unit)
    }
}