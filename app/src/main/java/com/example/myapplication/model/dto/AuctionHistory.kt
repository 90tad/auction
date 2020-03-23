package com.example.myapplication.model.dto

data class AuctionHistory(
    var time: String,
    var date: String,
    var price: String,
    var name: String
) {
    init {
        time = "12:12"
        date = "Ngay 12/12/1212"
        price = "30.000.000vnd"
        name = "Nguoi dau gia"
    }
}
