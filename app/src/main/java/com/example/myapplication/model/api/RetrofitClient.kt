package com.example.myapplication.model.api

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//class RetrofitClient {
//
//    companion object {
//        private val sInstance: RetrofitClient by lazy { RetrofitClient() }
//        private lateinit var mContext: Context
//    }
//
//    fun getInstance(): RetrofitClient = sInstance
//
//    fun setContext(context: Context) {
//        mContext = context
//    }
//
//    private var mRetrofit: Retrofit
//
//    init {
//        val baseUrl = ""
//        mRetrofit = Retrofit
//            .Builder()
//            .baseUrl(baseUrl)
//            .client(
//                OkHttpClient
//                    .Builder()
//                    .addInterceptor(NetworkConnectionInterceptor(mContext))
//                    .build()
//            )
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//            .build()
//    }
//
//    fun getAPIService(): RetrofitApiService {
//        return mRetrofit.create(RetrofitApiService::class.java)
//    }
//
//}