package com.example.myapplication.main.main_tab.home

import android.content.Context
import com.example.myapplication.base.BaseNavigator
import com.example.myapplication.product_detail.ProductDetail

class HomeNavigator(context: Context) : BaseNavigator(context), HomeContract.Navigator {
    override fun navigateProductDetailScreen() {
        val intent = ProductDetail.getInstance(context)
        context.startActivity(intent)
    }
}
