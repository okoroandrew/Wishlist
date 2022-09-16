package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter(private var mWishes: List<Wish>): RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName = itemView.findViewById<TextView>(R.id.item_name_itemContent)
        val itemPrice = itemView.findViewById<TextView>(R.id.item_price_itemContent)
        val itemUrl = itemView.findViewById<TextView>(R.id.item_url_itemContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val wishListView = inflater.inflate(R.layout.item_content, parent, false)
        return ViewHolder(wishListView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish: Wish = mWishes[position]

        holder.itemName.text = wish.itemName
        holder.itemPrice.text = wish.itemPrice
        holder.itemUrl.text = wish.itemUrl

    }

    override fun getItemCount(): Int {
        return mWishes.size
    }

}