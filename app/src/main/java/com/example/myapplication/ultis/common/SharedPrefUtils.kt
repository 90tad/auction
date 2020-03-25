package com.example.myapplication.ultis.common

import android.app.Application
import android.content.SharedPreferences
import com.example.myapplication.App
import com.example.myapplication.model.dto.GetAuthoritiesResponse
import com.example.myapplication.model.dto.SignInResponse
import com.example.myapplication.model.dto.User
import com.google.gson.Gson

object SharedPrefUtils {
    private const val CURRENT_USER_DETAIL_KEY = "currentUser"
    private const val SIGN_IN_KEY = "signInResponse"
    private const val USER_DISPLAY_NAME_KEY = "displayName"
    private const val USER_AUTHORITY_KEY = "authority"
    private const val USER_AVATAR_ID = "avatarId"
    private const val DEF_VALUE = ""
    private val mContext = App.applicationContext()

    fun getInstance(): SharedPreferences {
        return mContext.getSharedPreferences(
            SIGN_IN_KEY, Application.MODE_PRIVATE
        )
    }

    fun putSignInResponse(signInResponse: SignInResponse) {
        val signInResponseJson = Gson().toJson(signInResponse)
        getInstance()
            .edit()
            .putString(SIGN_IN_KEY, signInResponseJson)
            .apply()
    }

    fun putCurrentUserDetail(user: User) {
        val userJson = Gson().toJson(user)
        getInstance()
            .edit()
            .putString(CURRENT_USER_DETAIL_KEY, userJson)
            .apply()
    }

    fun getCurrentUserDetail(): User {
        val currentUserJson = getInstance().getString(CURRENT_USER_DETAIL_KEY, DEF_VALUE)
        return Gson().fromJson(currentUserJson, User::class.java)
    }

    fun putUserDisplayName(displayName: String) {
        getInstance()
            .edit()
            .putString(USER_DISPLAY_NAME_KEY, displayName)
            .apply()
    }

    fun putUserAuthority(authoritiesResponseList: List<GetAuthoritiesResponse>) {
        val gson = Gson()
        val authoritiesResponseStringList = hashSetOf<String>()
        authoritiesResponseList.map { e: GetAuthoritiesResponse ->
            authoritiesResponseStringList.add(gson.toJson(e))
        }
        getInstance()
            .edit()
            .putStringSet(USER_AUTHORITY_KEY, authoritiesResponseStringList)
            .apply()
    }

    fun getUserAuthority(): List<GetAuthoritiesResponse> {
        val set = getInstance().getStringSet(USER_AUTHORITY_KEY, null)
        val authoritiesResponseList = arrayListOf<GetAuthoritiesResponse>()
        set?.map { authority ->
            val formatedAuthority = Gson().fromJson(authority, GetAuthoritiesResponse::class.java)
            authoritiesResponseList.add(formatedAuthority)
        }
        return authoritiesResponseList
    }

    fun getUserDisplayName(): String? {
        return getInstance().getString(USER_DISPLAY_NAME_KEY, DEF_VALUE)
    }

    fun getSignInResponse(): SignInResponse {
        val signInResponseJson = getInstance().getString(SIGN_IN_KEY, DEF_VALUE)
        return Gson().fromJson(signInResponseJson, SignInResponse::class.java)
    }
}
