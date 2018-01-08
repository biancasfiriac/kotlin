package com.example.bianca.kotlinproject.firebase

import android.content.ContentValues
import android.util.Log
import com.example.bianca.kotlinproject.Song
import com.google.firebase.database.*

/**
 * Created by sfiriac on 1/5/2018.
 */


object FirebaseDb {

    fun getAllSongs() {
        val database = getFirebaseInstance() as FirebaseDatabase
        val myRef = database.getReference("songs") as DatabaseReference

        val songsList = ArrayList<Song>()

        val childEventListener = object : ChildEventListener {
            override fun onChildMoved(dataSnapshot: DataSnapshot?, previousChild: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot?, previousChild: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildAdded(dataSnapshot: DataSnapshot?, previousChild: String?) {
                Log.d(ContentValues.TAG, "child added")

                if (dataSnapshot != null) {
                    val song = Song()
                    song.title = dataSnapshot.child("title").value as String
                    song.artist = dataSnapshot.child("artist").value as String

                    songsList.add(song)
                }
            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addChildEventListener(childEventListener)

        return songsList

    }

    private fun getFirebaseInstance(): FirebaseDatabase? = FirebaseDatabase.getInstance()

}