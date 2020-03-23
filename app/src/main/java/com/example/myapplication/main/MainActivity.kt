package com.example.myapplication.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.constant.PreferenceKey
import com.example.myapplication.main.main_tab.home.HomeFragment
import com.example.myapplication.main.main_tab.notification.NotificationFragment
import com.example.myapplication.main.main_tab.personal.PersonalFragment
import com.example.myapplication.main.main_tab.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_app_bar.view.*

class MainActivity : AppCompatActivity() {
    companion object {
        private const val SEARCH_TAB_POSITION = 0
        private const val HOME_TAB_POSITION = 1
        private const val NOTIFICATION_TAB_POSITION = 2
        private const val PERSONAL_TAB_POSITION = 3
        private const val LOG_TAG = "asd"
        private val mFragmentList = arrayListOf<Fragment>()
        private val mHomeFragment =
            HomeFragment()
        private val mSearchFragment =
            SearchFragment()
        private val mPersonalFragment =
            PersonalFragment()
        private val mNotificationFragment =
            NotificationFragment()
        private lateinit var mNavListener: BottomNavigationView.OnNavigationItemSelectedListener
        private lateinit var mMainViewPagerAdapter: MainViewPagerAdapter
        private lateinit var mMainViewPagerPageChangeListener: ViewPager.OnPageChangeListener

        fun getInstance(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //token
        val preference = getSharedPreferences(PreferenceKey.getTokenKey(), Context.MODE_PRIVATE)
        val token = preference.getString(PreferenceKey.getTokenKey(), null)
        Log.d("asd", "token: $token")

        mNavListener = initNavListener()
        mMainViewPagerPageChangeListener = initMainViewPagerPageChangeListener()

        mainBottomNav.setOnNavigationItemSelectedListener(mNavListener)
        mainViewPager.addOnPageChangeListener(mMainViewPagerPageChangeListener)
        initMainViewPager()
        configActionBar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_toolbar_menu, menu)
        return true
    }

    private fun initNavListener(): BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView
            .OnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.main_nav_home -> {
                        mainViewPager.currentItem =
                            HOME_TAB_POSITION
                    }
                    R.id.main_nav_search -> {
                        mainViewPager.currentItem =
                            SEARCH_TAB_POSITION
                    }
                    R.id.main_nav_auction -> {
                        mainViewPager.currentItem =
                            NOTIFICATION_TAB_POSITION
                    }
                    R.id.main_nav_sign_in -> {
                        mainViewPager.currentItem =
                            PERSONAL_TAB_POSITION
                    }
                    else -> mainViewPager.currentItem =
                        HOME_TAB_POSITION
                }
                true
            }
    }

    private fun initMainViewPagerPageChangeListener(): ViewPager.OnPageChangeListener {
        return object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) = Unit

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) = Unit

            override fun onPageSelected(position: Int) {
                mainBottomNav.menu.getItem(position).isChecked = true
                when (position) {
                    HOME_TAB_POSITION -> onHomeTabSelected()
                    SEARCH_TAB_POSITION -> onSearchTabSelected()
                    NOTIFICATION_TAB_POSITION -> onAuctionTabSelected()
                    PERSONAL_TAB_POSITION -> onSignInTabSelected()
                    else -> onHomeTabSelected()
                }
            }
        }
    }

    private fun initMainViewPager() {
        mFragmentList.add(
            mSearchFragment
        )
        mFragmentList.add(
            mHomeFragment
        )
        mFragmentList.add(
            mNotificationFragment
        )
        mFragmentList.add(
            mPersonalFragment
        )
        mMainViewPagerAdapter =
            MainViewPagerAdapter(
                supportFragmentManager
            )
        mMainViewPagerAdapter.setFragmentList(
            mFragmentList
        )
        mainViewPager.adapter =
            mMainViewPagerAdapter
        mainViewPager.currentItem = HOME_TAB_POSITION
    }

    private fun configActionBar() {
        setSupportActionBar(mainAppBar.mainToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    private fun onHomeTabSelected() {
        Log.d(LOG_TAG, "HOME TAB SELECTED")
    }

    private fun onSearchTabSelected() {
        Log.d(LOG_TAG, "SEARCH TAB SELECTED")
    }

    private fun onAuctionTabSelected() {
        Log.d(LOG_TAG, "AUCTION TAB SELECTED")
    }

    private fun onSignInTabSelected() {
        Log.d(LOG_TAG, "SIGN IN TAB SELECTED")
    }
}
