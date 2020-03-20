package com.example.myapplication.base

interface BasePresenter<in T> {
    fun setView(view: T)
    fun onStart()
    fun onStop()
}
