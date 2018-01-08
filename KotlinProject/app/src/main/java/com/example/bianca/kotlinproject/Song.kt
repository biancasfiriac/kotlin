package com.example.bianca.kotlinproject

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by sfiriac on 10/13/2017.
 */

@Entity
data class Song(@PrimaryKey var id: Int,
                var cover: Int = R.drawable.coldplay_album_cover,
                var title: String = "none",
                var artist: String = "none")
