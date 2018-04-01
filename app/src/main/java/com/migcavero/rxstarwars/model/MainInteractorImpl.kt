package com.migcavero.rxstarwars.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class MainInteractorImpl : MainInteractor {

    private val mStarWarsClient: StarWarsClient

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        mStarWarsClient = retrofit.create(StarWarsClient::class.java)
    }

    override fun requestFilms(): Observable<Film> {
        val observable: Observable<Film>
        observable = mStarWarsClient.getFilmResult()
                .flatMap { filmResult -> Observable.fromIterable(filmResult.results) }
                .map { film -> Film(film.title, film.episodeId, film.charactersList) }

        return observable
    }

}