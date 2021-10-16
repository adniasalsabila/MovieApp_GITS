package com.gits.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gits.movieapp.model.MovieResponse
import com.gits.movieapp.model.ResultsItem
import com.gits.movieapp.presenter.MainPresenter
import com.gits.movieapp.presenter.MainView
import com.gits.movieapp.rest.Api
import com.gits.movieapp.rest.RetrofitClient
import com.gits.movieapp.ui.adapter.MovieApiAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity(), MainView {
    val movieApiAdapter = MovieApiAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = movieApiAdapter

        val presenter = MainPresenter(this)

        presenter.getDataMovie()
    }

    override fun hasilPresenter(data: Api) {
        Log.d("Data movie", data.getMovie().toString())
    }
}