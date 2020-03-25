package com.example.myapplication.model.dto

import com.google.gson.annotations.SerializedName

data class GetUserAvatarIdResponse(
    @SerializedName("idUpload")
    var idUpload: String
)