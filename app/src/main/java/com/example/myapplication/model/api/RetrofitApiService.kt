package com.example.myapplication.model.api

import com.example.myapplication.model.dto.*
import com.example.myapplication.ultis.common.SharedPrefUtils
import io.reactivex.Single
import retrofit2.http.*

interface RetrofitApiService {

    @Headers(value = ["Accept: application/json", "Content-type:application/json"])
    @POST("account/public/Account/mobile/login")
    fun signIn(
        @Body signInRequest: SignInRequest
    ): Single<SignInResponse>

    @GET("account/auth/user/Account/displayName")
    fun getDisplayName(
        @HeaderMap headers: HashMap<String, String>
    ): Single<GetDisplayNameResponse>

    @GET("account/auth/user/Authority/getAuthorities")
    fun getAuthorities(
        @HeaderMap headers: HashMap<String, String>
    ): Single<List<GetAuthoritiesResponse>>

    @GET("account/auth/user/Avartar/getDefault")
    fun getAvatarId(
        @HeaderMap headers: HashMap<String, String>
    ): Single<GetUserAvatarIdResponse>

}
