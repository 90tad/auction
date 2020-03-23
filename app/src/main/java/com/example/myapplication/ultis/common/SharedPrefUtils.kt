package com.example.myapplication.ultis.common

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

object SharedPrefUtils {
    private const val SIGN_IN_KEY = "signInResponse"
    lateinit var mContext: Context
    fun getTokenKey(): String =
        SIGN_IN_KEY

    fun getInstance(): SharedPreferences {
        return mContext.getSharedPreferences(
            SIGN_IN_KEY, Application.MODE_PRIVATE
        )
    }
}
