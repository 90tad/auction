package com.example.myapplication.listener

interface ItemClickListener<in T> {
    fun onClick(model: T)
}
