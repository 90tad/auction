package com.example.myapplication.model.dto

data class User(
    var authorities: ArrayList<GetAuthoritiesResponse>,
    var displayName: String,
    var avatarUrl: String
)
