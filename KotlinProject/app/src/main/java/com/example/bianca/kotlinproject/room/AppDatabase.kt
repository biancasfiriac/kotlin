package com.example.bianca.kotlinproject.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.content.ContentValues
import android.util.Log
import com.example.bianca.kotlinproject.Song
import com.google.firebase.database.*


/**
 * Created by sfiriac on 11/27/2017.
 */

@Database(entities = arrayOf(Song::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun songDao(): SongDao

}