package com.example.myapplication.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("username")
    @Expose
    var username: String,
    @Expose
    @SerializedName("password")
    var password: String
)
