package com.example.myapplication.product_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.product_detail.adapter.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetail : AppCompatActivity() {

    companion object {
        lateinit var mFragmentAdapter: FragmentAdapter
        lateinit var mOnTabSelectedListener: TabLayout.OnTabSelectedListener
        lateinit var mOnPageChangeListener: ViewPager.OnPageChangeListener
        fun getInstance(context: Context): Intent = Intent(context, ProductDetail::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        initView()
    }

    private fun initView() {
        mFragmentAdapter = FragmentAdapter(supportFragmentManager)
        product_detail_view_pager.adapter = mFragmentAdapter
        mOnPageChangeListener = initViewPagerPageChangeListener()
        mOnTabSelectedListener = initTabLayoutSelectedListener()
        product_detail_tab_layout.addOnTabSelectedListener(mOnTabSelectedListener)
        product_detail_view_pager.addOnPageChangeListener(mOnPageChangeListener)
    }

    private fun initTabLayoutSelectedListener(): TabLayout.OnTabSelectedListener {
        return object :
            TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) = Unit
            override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    product_detail_view_pager.currentItem = tab.position
                }
            }
        }
    }

    private fun initViewPagerPageChangeListener(): ViewPager.OnPageChangeListener {
        return object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) = Unit

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) = Unit

            override fun onPageSelected(position: Int) {
                product_detail_tab_layout.getTabAt(position)?.select()
            }
        }


    }
}
