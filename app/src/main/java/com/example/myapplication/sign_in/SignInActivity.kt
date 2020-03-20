package com.example.myapplication.sign_in

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    companion object {
        fun getInstance(context: Context): Intent = Intent(context, SignInActivity::class.java)
    }

    private val mPresenter by lazy { SignInPresenter() }
    private val mNavigator by lazy { SignInNavigator(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        sign_up_button.setOnClickListener {
            mNavigator.navigateSignUpScreen()
        }

        submit_sign_in_button.setOnClickListener {
            mNavigator.navigateMainScreen()
        }

    }
}
