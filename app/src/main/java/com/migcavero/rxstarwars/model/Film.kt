package com.migcavero.rxstarwars.model

import com.google.gson.annotations.SerializedName

class Film(val title: String,
           @SerializedName("episode_id") val episodeId: Int,
           @SerializedName("characters") val charactersList: List<String>)