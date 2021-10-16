package com.gits.movieapp.presenter

import com.gits.movieapp.rest.Api

interface MainView {
    fun hasilPresenter(data: Api)
}