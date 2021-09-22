package com.gits.movieapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gits.movieapp.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        view_title.text = intent.getStringExtra("JUDUL")
        view_overview.text = intent.getStringExtra("OVERVIEW")
    }
}