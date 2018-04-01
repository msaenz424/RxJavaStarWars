package com.migcavero.rxstarwars.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.migcavero.rxstarwars.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUI : AnkoComponent<MainActivity> {

    lateinit var mFilmsRecyclerView: RecyclerView

    override fun createView(ui: AnkoContext<MainActivity>): View {
        return with(ui) {
            frameLayout {
                lparams(width = matchParent, height = matchParent)
                mFilmsRecyclerView = recyclerView {
                    id = R.id.films_recycler_view
                    lparams(width = matchParent, height = matchParent)
                    layoutManager = LinearLayoutManager(ctx)
                }
            }
        }
    }
}