package com.example.myapplication.model

data class SignUpRequest(
    var userame: String,
    var displayName: String,
    var birthDay: String,
    var password: String,
    var confirmPassword: String,
    var phoneNumber: String,
    var email: String,
    var sex: Boolean
)
