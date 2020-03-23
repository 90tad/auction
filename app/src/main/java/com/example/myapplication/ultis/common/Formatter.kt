package com.example.myapplication.ultis.common

import java.text.NumberFormat
import java.util.*

object Formatter {
    fun formatCurrency(number: Int): String {
        val formatter = NumberFormat.getCurrencyInstance()
        formatter.maximumFractionDigits = 0
        formatter.currency = (Currency.getInstance("VND"))
        return formatter.format(number)
    }
}
