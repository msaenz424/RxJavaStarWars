package com.migcavero.rxstarwars.model

import io.reactivex.Observable

interface MainInteractor {

    fun requestFilms(): Observable<Film>

}