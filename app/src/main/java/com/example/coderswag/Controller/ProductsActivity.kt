package com.example.coderswag.Controller

import android.content.res.Configuration
import android.nfc.cardemulation.CardEmulation.EXTRA_CATEGORY
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coderswag.Adapters.ProductsAdapter
import com.example.coderswag.Services.DataService
import com.example.coderswag.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = categoryType?.let { DataService.getProducts(it) }?.let {
            ProductsAdapter(this,
                it
            )
        }!!

        var spanCount = 3
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 5
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720 && orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 7
        }
        if (screenSize > 720 && orientation == Configuration.ORIENTATION_PORTRAIT) {
            spanCount = 5
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        binding.productsListView.layoutManager = layoutManager
        binding.productsListView.adapter = adapter
    }
}