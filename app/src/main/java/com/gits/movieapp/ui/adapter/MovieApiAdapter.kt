package com.gits.movieapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gits.movieapp.R
import com.gits.movieapp.model.ResultsItem
import com.gits.movieapp.ui.activity.DetailActivity

class MovieApiAdapter(val results: ArrayList<ResultsItem>) :
    RecyclerView.Adapter<MovieApiAdapter.ViewHolder>() {

    fun setData(data: List<ResultsItem>) {
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieApiAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MovieApiAdapter.ViewHolder, position: Int) {
        val data = results[position]
        Glide.with(holder.itemView)
            .load("https://www.themoviedb.org/t/p/w220_and_h330_face${data.posterPath}").apply(
                RequestOptions().override(320, 320)
            ).into(holder.image)
        holder.judul.text = data.title
        holder.rating.text = "Rating : ${data.voteAverage.toString()}"
        holder.releaseDate.text = "Rilis : ${data.releaseDate.toString()}"
        holder.klik.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("TITLE", data.title)
            intent.putExtra("RATING", data.voteAverage.toString())
            intent.putExtra("RELEASE", data.releaseDate)
            intent.putExtra("OVERVIEW", data.overview)
            intent.putExtra("POSTER", "https://www.themoviedb.org/t/p/w220_and_h330_face${data.posterPath}")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val judul: TextView = itemView.findViewById(R.id.view_tittle)
        val rating: TextView = itemView.findViewById(R.id.view_rating)
        val releaseDate: TextView = itemView.findViewById(R.id.view_release)
        val image: ImageView = itemView.findViewById(R.id.poster_list_data)
        val klik: CardView = itemView.findViewById(R.id.cardView_item)
    }
}