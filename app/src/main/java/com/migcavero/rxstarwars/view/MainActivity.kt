package com.migcavero.rxstarwars.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.migcavero.rxstarwars.model.Film
import com.migcavero.rxstarwars.presenter.MainPresenter
import com.migcavero.rxstarwars.presenter.MainPresenterImpl
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mMainUi: MainActivityUI
    private lateinit var mFilmsAdapter: FilmsAdapter

    private lateinit var mMainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainUi = MainActivityUI()
        mMainUi.setContentView(this)
        mMainPresenter = MainPresenterImpl(this)
        mMainPresenter.onCreate()
    }

    override fun displayFilms(filmArrayList: ArrayList<Film>) {
        mFilmsAdapter = FilmsAdapter(filmArrayList)
        mMainUi.mFilmsRecyclerView.adapter = mFilmsAdapter
    }

}
