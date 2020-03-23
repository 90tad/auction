package com.example.myapplication.model.api

import com.example.myapplication.model.dto.SignInRequest
import com.example.myapplication.model.dto.SignInResponse
import io.reactivex.Single
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitApiService {

    companion object {
        private const val BASE_URL =
            "http://103.74.116.95:8084/"
        private val mHttpLoggingInterceptorLevel = HttpLoggingInterceptor.Level.BODY
        private val logging: Interceptor =
            HttpLoggingInterceptor()
                .setLevel(mHttpLoggingInterceptorLevel)
        private val client: OkHttpClient =
            OkHttpClient
                .Builder()
                .connectionSpecs(listOf(ConnectionSpec.CLEARTEXT))
                .addInterceptor(logging)
                .build()

        fun create(): RetrofitApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()
            return retrofit.create(RetrofitApiService::class.java)
        }
    }

    @Headers(value = ["Accept: application/json", "Content-type:application/json"])
//    @FormUrlEncoded
    @POST("account/public/Account/mobile/login")
    fun signIn(
        @Body signInRequest: SignInRequest
    ): Single<SignInResponse>

    @Headers(
        value = [
            "Accept: */*",
            ""
        //TODO:
        ]
    )
    @GET("auth/user/Account/displayName")
    fun getDisplayName(): Single<String>
}
