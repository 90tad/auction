package com.example.myapplication.sign_in

import com.example.myapplication.model.api.RetrofitApiService
import com.example.myapplication.model.dto.SignInRequest
import com.example.myapplication.model.dto.SignInResponse
import com.example.myapplication.ultis.common.ValidationCheck
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SignInPresenter : SignInContract.Presenter {

    private lateinit var mView: SignInContract.View
    private val mCompositeDisposable = CompositeDisposable()

    //    lateinit var mUserRepository: UserRepository
    private var mSignInRequest =
        SignInRequest(NULL, NULL)

    companion object {
        private var apiService = RetrofitApiService.create()
        private const val NULL = ""
    }

    override fun signIn() {

        if (!ValidationCheck.isSignInValid(mSignInRequest)) {
            mView.onSignInInputInvalid()
        }

        val disposable = apiService
            .signIn(mSignInRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t: SignInResponse ->
                mView.onSignInSuccess(t)
            }, { t: Throwable ->
                mView.onSignInError()
            })
        mCompositeDisposable.add(disposable)

    }

    override fun listenForUsernameInput(text: String) {
        if (!ValidationCheck.isUsernameValid(text)) {
            mView.onUsernameInputInvalid()
        }
        mSignInRequest.username = text
    }

    override fun listenForPasswordInput(text: String) {
        if (!ValidationCheck.isPasswordValid(text)) {
            mView.onPasswordInputInvalid()
        }
        mSignInRequest.password = text
    }

    override fun setView(view: SignInContract.View) {
        this.mView = view
    }

    override fun onStart() = signIn()

    override fun onStop() {
        mCompositeDisposable.clear()
    }

}