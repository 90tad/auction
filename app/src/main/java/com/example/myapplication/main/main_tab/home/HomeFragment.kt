package com.example.myapplication.main.main_tab.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.listener.ItemClickListener
import com.example.myapplication.main.main_tab.home.adapter.ProductRecyclerViewAdapter
import com.example.myapplication.model.Product
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), ItemClickListener<Product> {

    companion object {
        private lateinit var mNavigator: HomeNavigator
        private lateinit var mAdapter: ProductRecyclerViewAdapter
        private lateinit var mContext: Context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mNavigator = HomeNavigator(mContext)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf<Product>()
        list.add(Product())
        list.add(Product())
        list.add(Product())
        list.add(Product())
        list.add(Product())
        list.add(Product())
        list.add(Product())
        list.add(Product())
        list.add(Product())

        mAdapter = ProductRecyclerViewAdapter(mContext, list)
        mAdapter.setItemClickListener(this)
        homeProductRecyclerView.adapter = mAdapter
        homeProductRecyclerView.layoutManager = GridLayoutManager(mContext, 2)
    }

    override fun onClick(model: Product) {
        mNavigator.navigateProductDetailScreen()
    }

}
