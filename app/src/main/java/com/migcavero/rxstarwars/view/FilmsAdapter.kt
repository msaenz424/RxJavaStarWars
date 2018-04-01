package com.migcavero.rxstarwars.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.migcavero.rxstarwars.R
import com.migcavero.rxstarwars.model.Film
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class FilmsAdapter constructor(filmArrayList: ArrayList<Film>): RecyclerView.Adapter<FilmsAdapter.FilmViewHolder>() {

    private var mFilmsArrayList = filmArrayList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(FilmItemUI().createView( AnkoContext.create(parent.context, parent, false)))
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.filmNameTextView.text = mFilmsArrayList[position].title
    }

    override fun getItemCount(): Int {
        return mFilmsArrayList.size
    }

    class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val filmNameTextView: TextView = itemView.find(R.id.film_name_text_view)

    }
}