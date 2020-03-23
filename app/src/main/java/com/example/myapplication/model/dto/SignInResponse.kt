package com.example.myapplication.model.dto

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SignInResponse(
    @SerializedName("token")
    @Expose
    val token: String,
    @SerializedName("enableAdmin")
    @Expose
    val enableAdmin: Boolean,
    @SerializedName("enablePartner")
    @Expose
    val enablePartner: Boolean
) : Parcelable
