package com.example.myapplication.sign_in

import com.example.myapplication.base.BasePresenter
import com.example.myapplication.base.BaseView
import com.example.myapplication.model.SignInRequest

interface SignInContract {

    interface View : BaseView {
    }

    interface Presenter : BasePresenter<View> {
        fun signIn(signInRequest: SignInRequest)
    }

    interface Navigator {
        fun navigateSignUpScreen()
        fun navigateMainScreen()
    }
}