package com.example.myapplication.model.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetDisplayNameResponse(
    @SerializedName("displayName")
    var displayName: String
) : Parcelable