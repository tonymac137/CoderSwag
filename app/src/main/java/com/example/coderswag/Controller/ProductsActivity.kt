package com.example.coderswag.Controller

import android.nfc.cardemulation.CardEmulation.EXTRA_CATEGORY
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coderswag.databinding.ActivityMainBinding
import com.example.coderswag.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)
    }
}