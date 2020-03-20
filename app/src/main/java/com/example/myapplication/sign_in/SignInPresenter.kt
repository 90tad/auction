package com.example.myapplication.sign_in

import com.example.myapplication.model.SignInRequest

class SignInPresenter : SignInContract.Presenter {

    private lateinit var mView: SignInContract.View

    override fun signIn(signInRequest: SignInRequest) {
    }

    override fun setView(view: SignInContract.View) {
        this.mView = view
    }

    override fun onStart() {

    }

    override fun onStop() {

    }

}