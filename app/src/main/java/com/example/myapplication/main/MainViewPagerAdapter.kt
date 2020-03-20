package com.example.myapplication.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

    private lateinit var mFragmentList: ArrayList<Fragment>
    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun setFragmentList(fragmentList: ArrayList<Fragment>) {
        this.mFragmentList = fragmentList
    }
}
