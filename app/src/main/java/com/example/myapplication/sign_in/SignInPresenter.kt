package com.example.myapplication.sign_in

import android.util.Log
import com.example.myapplication.model.api.RetrofitClient
import com.example.myapplication.model.dto.SignInRequest
import com.example.myapplication.model.repository.UserRepositoryImp
import com.example.myapplication.ultis.common.ValidationCheck
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SignInPresenter : SignInContract.Presenter {

    private lateinit var mView: SignInContract.View
    private val mCompositeDisposable = CompositeDisposable()

    private var mUserRepository = UserRepositoryImp()
    private var mSignInRequest =
        SignInRequest("admin", "12345678")

    /**
     *
     */
    companion object {
        private var apiService = RetrofitClient().getInstance().getAPIService()
        private const val NULL = ""
    }

    /**
     *
     */

//    override fun signIn() {
//
//        if (!ValidationCheck.isSignInValid(mSignInRequest)) {
//            mView.onSignInInputInvalid()
//        }
//        val disposable = apiService
//            .signIn(mSignInRequest)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ t: SignInResponse ->
//                Log.d("asd", t.toString())
//                SharedPrefUtils
//                    .putSignInResponse(t)
//
//                apiService
//                    .getDisplayName()
//                    .subscribeOn(Schedulers.io())
//                    .subscribe({ response ->
//                        Log.d("asd", "getNameSuccess: ${response.displayName}")
//                    }, {
//                        Log.d("asd", "getNameError: $it")
//                    })
//
//            }, { t: Throwable ->
//                mView.onSignInError()
//            })
//        mCompositeDisposable.add(disposable)
//
//    }

    override fun signIn() {
        if (!ValidationCheck.isSignInValid(mSignInRequest)) {
            mView.onSignInInputInvalid()
        }
        val disposable =
            mUserRepository.signIn(mSignInRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mView.onSignInSuccess()
                    Log.d("asd", "user: $it")
                }, {
                    mView.onSignInError()
                })
        mCompositeDisposable.add(disposable)
    }

    /**
     * @param text
     */
    override fun listenForUsernameInput(text: String) {
        if (!ValidationCheck.isUsernameValid(text)) {
            mView.onUsernameInputInvalid()
        }
        mSignInRequest.username = text
    }


    /**
     *
     */
    override fun listenForPasswordInput(text: String) {
        if (!ValidationCheck.isPasswordValid(text)) {
            mView.onPasswordInputInvalid()
        }
        mSignInRequest.password = text
    }

    /**
     * @param view
     *
     */
    override fun setView(view: SignInContract.View) {
        this.mView = view
    }

    override fun onStart() = signIn()

    override fun onStop() {
        mCompositeDisposable.clear()
    }

}
