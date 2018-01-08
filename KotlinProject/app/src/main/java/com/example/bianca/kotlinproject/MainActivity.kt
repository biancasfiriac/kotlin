package com.example.bianca.kotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity(), SongsAdapter.ListItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.songs_recycler_view) as RecyclerView
        val list = SongsDao.getAllSongs()
//        mockSongsList(list)

        val adapter = SongsAdapter(list, this)
        recyclerView.adapter = adapter

        val orientation : Int = getResources().getConfiguration().orientation
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onListItemClick(index: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun mockSongsList(list: ArrayList<Song>) {
        list.add(Song(R.drawable.coldplay_album_cover, "A sky full of stars", "Coldplay"))
        list.add(Song(R.drawable.coldplay_album_cover, "Photograph", "Ed Sheeran"))
        list.add(Song(R.drawable.coldplay_album_cover, "Where is the love", "Black Eyed Peas"))
        list.add(Song(R.drawable.coldplay_album_cover, "In the air tonight", "Phil Collins"))
        list.add(Song(R.drawable.coldplay_album_cover, "Let her go", "Passenger"))
        list.add(Song(R.drawable.coldplay_album_cover, "Read all about it", "Emili Sande"))
        list.add(Song(R.drawable.coldplay_album_cover, "When we were young", "Adele"))
        list.add(Song(R.drawable.coldplay_album_cover, "All of me", "John Legend"))
    }
}
