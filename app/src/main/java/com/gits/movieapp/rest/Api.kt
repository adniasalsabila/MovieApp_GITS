package com.gits.movieapp.rest

import com.gits.movieapp.model.MovieResponse
import com.gits.movieapp.model.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movie/popular?api_key=9b15d94167f6e6c611e5f3f9907c8c76&language=en&page=1")
    fun getMovie(): Call<MovieResponse>
    @GET("tv/popular?api_key=9b15d94167f6e6c611e5f3f9907c8c76&language=en&page=1")
    fun getTv(): Call<TvShowResponse>
}