package com.example.myapplication.sign_in

import com.example.myapplication.base.BasePresenter
import com.example.myapplication.base.BaseView
import com.example.myapplication.model.dto.SignInResponse

interface SignInContract {

    interface View : BaseView {
        fun onSignInSuccess(signInResponse: SignInResponse)
        fun onSignInError()
        fun onUsernameInputInvalid()
        fun onPasswordInputInvalid()
        fun onSignInInputInvalid()
    }

    interface Presenter : BasePresenter<View> {
        fun signIn()
        fun listenForUsernameInput(text: String)
        fun listenForPasswordInput(text: String)
    }

    interface Navigator {
        fun navigateSignUpScreen()
        fun navigateMainScreen()
    }
}