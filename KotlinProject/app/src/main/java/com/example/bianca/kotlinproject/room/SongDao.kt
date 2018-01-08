package com.example.bianca.kotlinproject.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.bianca.kotlinproject.Song

/**
 * Created by sfiriac on 1/5/2018.
 */

@Dao
interface SongDao {

    @Query("SELECT * FROM song")
    fun getAll(): List<Song>

    @Insert
    fun insertAll(songs: List<Song>)

    @Insert
    fun insertOne(song: Song)
}