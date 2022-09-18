package com.example.wishlist

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wishlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myWishList: ArrayList<Wish> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val itemName = binding.itemNameEditTextView.text.toString()
            val itemPrice = binding.itemPriceEditTextView.text.toString()
            val itemUrl = binding.itemUrlEditTextView.text.toString()

            myWishList.add(Wish(itemName, itemPrice, itemUrl))

            binding.recyclerView.adapter = WishListAdapter(myWishList)
            binding.recyclerView.layoutManager = LinearLayoutManager(this)

            //Hide keyword and clear editText
            it.hideKeyboard()
            binding.itemNameEditTextView.text.clear()
            binding.itemPriceEditTextView.text.clear()
            binding.itemUrlEditTextView.text.clear()
        }


    }

    private fun onListItemClick(position: Int){
        Toast.makeText(this, "i love $position", Toast.LENGTH_SHORT).show()
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}