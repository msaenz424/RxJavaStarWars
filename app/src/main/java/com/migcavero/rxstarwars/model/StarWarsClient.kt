package com.migcavero.rxstarwars.model

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface StarWarsClient{
    @GET("films")
    fun getFilms(): Observable<FilmsList>

    @GET("/people/{personId}")
    fun getPeople(@Path("personId") personId: String): Observable<Character>
}