package com.example.myapplication.model.dto

import com.google.gson.annotations.SerializedName

data class GetAuthoritiesResponse(
    @SerializedName("name")
    var name: String,
    @SerializedName("uuid")
    var uuid: String
)
