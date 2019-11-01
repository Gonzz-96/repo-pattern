package com.gonz.mx.repo.pattern.view.main

interface MainContract {
    interface View
    interface Presenter {
        fun deletePokemonsFromDB()
    }
}