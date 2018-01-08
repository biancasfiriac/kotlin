package com.example.bianca.kotlinproject

import android.support.v7.widget.RecyclerView
import android.content.Context
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by sfiriac on 10/13/2017.
 */

class SongsAdapter(private val list: List<Song>, val onClickListener: SongsAdapter.ListItemClickListener) : RecyclerView.Adapter<SongsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsAdapter.ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.song_card_view, parent, false)
        val card = view.findViewById(R.id.card_view) as CardView
        card.radius = 5.0F
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongsAdapter.ViewHolder, position: Int) {
        var song : Song = list.get(position)
        holder.titleTextView.text = song.title
        holder.artistTextView.text = song.artist
        holder.coverImageView.setImageResource(song.cover)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var titleTextView: TextView
        var artistTextView: TextView
        var coverImageView: ImageView

        init {
            titleTextView = itemView.findViewById(R.id.song_title) as TextView
            artistTextView = itemView.findViewById(R.id.song_artist) as TextView
            coverImageView = itemView.findViewById(R.id.song_cover) as ImageView
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val clickedPosition = adapterPosition
            onClickListener.onListItemClick(clickedPosition)
        }
    }

    interface ListItemClickListener {
        fun onListItemClick(index: Int)
    }
}
