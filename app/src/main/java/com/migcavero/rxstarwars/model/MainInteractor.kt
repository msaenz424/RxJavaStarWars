package com.migcavero.rxstarwars.model

import rx.Observable

interface MainInteractor {

    fun requestFilms(): Observable<Film>

}