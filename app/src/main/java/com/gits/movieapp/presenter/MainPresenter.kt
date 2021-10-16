package com.gits.movieapp.presenter

import android.widget.Toast
import com.gits.movieapp.model.MovieResponse
import com.gits.movieapp.model.ResultsItem
import com.gits.movieapp.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter (val data: MainView) {

    private fun getDataMovie() {
        RetrofitClient.instance.getMovie()
            .enqueue(object : Callback<MovieResponse> {
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