package com.migcavero.rxstarwars.presenter

import com.migcavero.rxstarwars.model.Film
import com.migcavero.rxstarwars.model.MainInteractorImpl
import com.migcavero.rxstarwars.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl constructor(mainView: MainView): MainPresenter {

    private val mMainView: MainView = mainView
    private val mMainInteractor = MainInteractorImpl()

    override fun onCreate() {
        val filmArrayList = ArrayList<Film>()

        mMainInteractor.requestFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // onNext
                    film -> filmArrayList.add(film)
                },{
                    // onError
                    e -> e.printStackTrace()
                },{
                    // onComplete
                    mMainView.displayFilms(filmArrayList)
                })
    }

}