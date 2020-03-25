package com.example.myapplication.model.api

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private val sInstance: RetrofitClient by lazy { RetrofitClient() }
        lateinit var mRetrofit: Retrofit
        private val mHttpLoggingInterceptorLevel = HttpLoggingInterceptor.Level.BODY
        private val logging: Interceptor =
            HttpLoggingInterceptor()
                .setLevel(mHttpLoggingInterceptorLevel)
    }

    fun getInstance(): RetrofitClient = sInstance

    init {
        val baseUrl = "http://103.74.116.95:8084/"
        mRetrofit = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient
                    .Builder()
                    .addNetworkInterceptor(NetworkConnectionInterceptor())
                    .addInterceptor(logging)
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    fun getAPIService(): RetrofitApiService {
        return mRetrofit.create(RetrofitApiService::class.java)
    }

}
