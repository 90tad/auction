package com.example.myapplication.sign_in

import android.content.Context
import com.example.myapplication.base.BaseNavigator
import com.example.myapplication.main.MainActivity
import com.example.myapplication.sign_up.SignUpActivity

class SignInNavigator(context: Context) : BaseNavigator(context), SignInContract.Navigator {
    override fun navigateSignUpScreen() {
        val intent = SignUpActivity.getInstance(context)
        context.startActivity(intent)
    }

    override fun navigateMainScreen() {
        val intent = MainActivity.getInstance(context)
        context.startActivity(intent)
    }
}
