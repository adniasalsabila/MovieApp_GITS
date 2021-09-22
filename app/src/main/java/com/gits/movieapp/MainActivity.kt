package com.gits.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gits.movieapp.model.MovieResponse
import com.gits.movieapp.model.ResultsItem
import com.gits.movieapp.rest.RetrofitClient
import com.gits.movieapp.ui.adapter.MovieApiAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity() {
    val movieApiAdapter = MovieApiAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = movieApiAdapter
        getDataMovie()
    }

    private fun getDataMovie() {
        RetrofitClient.instance.getMovie()
            .enqueue(object : Callback<MovieResponse>{
                override fun onResponse(
                    call: Call<MovieResponse>?,
                    response: Response<MovieResponse>?
                ) {
                    if (response!!.isSuccessful){
                        response.body()?.let { tampilMovie(it) }
                        val result = response.body()?.results
                        for (item in result!!){
                            detailMovie(item!!.id)
                        }
                    }else{
                        Toast.makeText(this@MainActivity, "Reponse Gagal", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                    Toast.makeText(this@MainActivity, "Reponse Gagal : ${t}", Toast.LENGTH_LONG).show()
                }

            })
    }
    private fun tampilMovie(data : MovieResponse){
        val result = data.results
        movieApiAdapter.setData(result as List<ResultsItem>)
    }

    private fun detailMovie(id: Int?){
        RetrofitClient
    }
}