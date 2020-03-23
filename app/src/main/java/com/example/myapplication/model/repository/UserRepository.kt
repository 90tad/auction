package com.example.myapplication.model.repository

import com.example.myapplication.model.dto.SignInResponse
import io.reactivex.Single

interface UserRepository {
    fun signIn(username: String, password: String): Single<SignInResponse>
}
