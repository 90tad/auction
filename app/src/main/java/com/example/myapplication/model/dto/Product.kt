package com.example.myapplication.model.dto

import android.os.CountDownTimer
import android.os.Parcelable
import com.example.myapplication.ultis.common.Formatter
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class
Product(
    @SerializedName("")
    var id: String? = null,
    @SerializedName("")
    var name: String? = null,
    @SerializedName("")
    var imageUrl: String? = null,
    @SerializedName("")
    var favorite: Boolean = false,
    @SerializedName("")
    var price: String? = null,
    @SerializedName("")
    var countDownTime: Long? = null,
    @SerializedName("")
    var rate: Float? = null,
    @SerializedName("")
    var rateCount: Int? = null
) : Parcelable {
    init {
        object : CountDownTimer(3000000, 1000) {
            override fun onFinish() {
            }

            override fun onTick(millisUntilFinished: Long) {
                countDownTime = (millisUntilFinished / 1000)
            }
        }
        id = "koi #r1015356"
        name = "Doitsu koihaku"
        price = Formatter.formatCurrency(25000000)
    }
}
