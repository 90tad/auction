package com.example.myapplication.main.main_tab.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.listener.ItemClickListener
import com.example.myapplication.model.dto.Product

class ProductRecyclerViewAdapter(var context: Context, var productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductViewHolder>() {

    private lateinit var mItemClickListener: ItemClickListener<Product>

    fun setItemClickListener(itemClickListener: ItemClickListener<Product>) {
        this.mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.apply {
            productNameTextView.text = "${productList[position].name} - ${productList[position].id}"
            productPriceTextView.text = productList[position].price
            productCountDownTimerTextView.text = productList[position].countDownTime.toString()
            bind(productList[position], mItemClickListener)

            if (productList[position].favorite) {
            } else {
            }
            productLikeImageView.setOnClickListener {
                productList[position].favorite = !productList[position].favorite
                if (productList[position].favorite) {

                } else {

                }
            }
        }
    }
}
