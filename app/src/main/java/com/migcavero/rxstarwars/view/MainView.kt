package com.migcavero.rxstarwars.view

import com.migcavero.rxstarwars.model.Film

interface MainView {

    fun displayFilms(filmArrayList: ArrayList<Film>)

}