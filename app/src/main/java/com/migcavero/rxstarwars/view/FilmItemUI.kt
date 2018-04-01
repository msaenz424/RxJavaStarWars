package com.migcavero.rxstarwars.view

import android.view.View
import android.view.ViewGroup
import com.migcavero.rxstarwars.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.textView

class FilmItemUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            textView{
                id = R.id.film_name_text_view
                textSize = 16f
            }
        }
    }

}