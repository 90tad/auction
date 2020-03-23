package com.example.myapplication.model.repository

import com.example.myapplication.model.dto.SignInResponse
import io.reactivex.Single

class UserRepositoryImp : UserRepository {
    override fun signIn(username: String, password: String): Single<SignInResponse> {
        return Single.create { emitter ->

        }
    }
}
