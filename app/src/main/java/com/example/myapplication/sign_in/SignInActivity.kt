package com.example.myapplication.sign_in

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.constant.Error
import com.example.myapplication.ultis.extensions.invisible
import com.example.myapplication.ultis.extensions.onTextChanged
import com.example.myapplication.ultis.extensions.visible
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), SignInContract.View {

    companion object {
        fun getInstance(context: Context): Intent = Intent(context, SignInActivity::class.java)
    }

    private val mPresenter by lazy { SignInPresenter() }
    private val mNavigator by lazy { SignInNavigator(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        mPresenter.setView(this)
        addTextChangeListener()

        sign_up_button.setOnClickListener {
            mNavigator.navigateSignUpScreen()
        }

        submit_sign_in_button.setOnClickListener {
            mPresenter.signIn()
            sign_in_progressBar.visible()
        }
    }

    override fun onSignInSuccess() {
        //TODO: SHOW PROGRESSBAR, SAVE TOKEN, NAVIGATE TO HOME SCREEN
//        val gSon = Gson()
//        val json = gSon.toJson(signInResponse)
//        val sharedPreferences = SharedPrefUtils.getInstance()
//        sharedPreferences.edit().putString(SIGN_IN_KEY, json).apply()

//        SharedPrefUtils.putSignInResponse(signInResponse)
        sign_in_progressBar.invisible()
        mNavigator.navigateMainScreen()
    }

    override fun onSignInError() {
        //TODO: SHOW ERROR, HIDE PROGRESSBAR
        sign_in_progressBar.invisible()
    }

    override fun onUsernameInputInvalid() {
        sign_in_username_edit_text.error = Error.INVALID_USERNAME
    }

    override fun onPasswordInputInvalid() {
        sign_in_pass_word_edit_text.error = Error.INVALID_PASSWORD
    }

    override fun onSignInInputInvalid() {


    }

    private fun addTextChangeListener() {
        sign_in_username_edit_text.onTextChanged { text ->
            mPresenter.listenForUsernameInput(text)
        }
        sign_in_pass_word_edit_text.onTextChanged { text ->
            mPresenter.listenForPasswordInput(text)
        }
    }
}
