package com.migcavero.rxstarwars.model

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

class MainInteractorImpl : MainInteractor {

    private val mStarWarsClient: StarWarsClient

    init {
        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        mStarWarsClient = retrofit.create(StarWarsClient::class.java)
    }

    override fun requestFilms(): Observable<Film> {
        val observable: Observable<Film>
        observable = mStarWarsClient.getFilms()
                // creates a single Observable for each item in list
                .flatMap { resultList -> Observable.from(resultList.filmsList) }
                // then pass the previous create Observable into a Film object
                .flatMap { resultFilm -> Observable.just(Film(resultFilm.title, resultFilm.episodeId, resultFilm.charactersList)) }

        // the final result is a single Observable of a Film
        return observable
    }

}