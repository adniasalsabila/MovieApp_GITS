package com.gits.movieapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gits.movieapp.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        view_title.text = intent.getStringExtra("TITLE")
        rating.text = intent.getStringExtra("RATING")
        release_date.text = intent.getStringExtra("RELEASE")
        view_overview.text = intent.getStringExtra("OVERVIEW")

        Glide.with(this)
            .load(intent.getStringExtra("POSTER")).apply(
                RequestOptions().override(320, 320)
            ).into(poster)

        Glide.with(this)
            .load(intent.getStringExtra("POSTER")).apply(
                RequestOptions().override(320, 320)
            ).into(header_poster)
    }
}