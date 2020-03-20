package com.example.myapplication.model

import android.os.CountDownTimer
import com.example.myapplication.ultis.Formatter

data class Product(
    var id: String? = null,
    var name: String? = null,
    var imageUrl: String? = null,
    var favorite: Boolean = false,
    var price: String? = null,
    var countDownTime: Long? = null,
    var rate: Float? = null,
    var rateCount: Int? = null
) {
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
