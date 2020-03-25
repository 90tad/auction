package com.example.myapplication.model.repository

import com.example.myapplication.model.dto.SignInRequest
import com.example.myapplication.model.dto.User
import io.reactivex.Single

interface UserRepository {
    fun signIn(signInRequest: SignInRequest): Single<User>
}
