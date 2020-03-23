package com.example.myapplication.main.main_tab.home.adapter

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.listener.ItemClickListener
import com.example.myapplication.model.dto.Product
import kotlinx.android.synthetic.main.product_item.view.*
import kotlinx.android.synthetic.main.rating_bar.view.*

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val productNameTextView: TextView = itemView.product_name_text_view
    val productRateCountTextView: TextView =
        itemView.product_count_down_time_text_view
    val productRateRatingBar: RatingBar = itemView.product_rating_bar.rating_bar
    val productPriceTextView: TextView = itemView.product_price_text_view
    val productImageView: ImageView = itemView.product_image_view
    val productCountDownTimerTextView: TextView = itemView.product_count_down_time_text_view
    val productLikeImageView: ImageView = itemView.product_like_image_view

    fun bind(product: Product, itemClickListener: ItemClickListener<Product>) {
        itemView.setOnClickListener {
            itemClickListener.onClick(product)
        }
    }
}
