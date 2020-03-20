package com.example.myapplication.product_detail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.product_detail.product_detail_tab.*

class FragmentAdapter(
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(
    fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    companion object {
        private val mAuctionRulesFragment = AuctionRulesFragment()
        private val mAuctionHistoryFragment = AuctionHistoryFragment()
        private val mCommentAndReviewFragment = CommentAndReviewFragment()
        private val mCommonQuestionsFragment = CommonQuestionsFragment()
        private val mShippingInformationFragment = ShippingInformationFragment()
        const val TAB_COUNT = 5
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                mAuctionRulesFragment
            }
            1 -> {
                mAuctionHistoryFragment
            }
            2 -> {
                mShippingInformationFragment
            }
            3 -> {
                mCommonQuestionsFragment
            }
            else -> {
                mCommentAndReviewFragment
            }
        }
    }

    override fun getCount(): Int = TAB_COUNT

}