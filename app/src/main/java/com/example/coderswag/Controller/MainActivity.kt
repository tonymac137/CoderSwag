package com.example.coderswag.Controller

// Kotlin for Android Beginner to Advanced
// Udemy
// Started 07/02/2021

import android.content.Intent
import android.nfc.cardemulation.CardEmulation.EXTRA_CATEGORY
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.Adapters.CategoryRecycleAdapter
import com.example.coderswag.Services.DataService
import com.example.coderswag.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Initialise the Adapter for the listView - using Model.Category
    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductsActivity::class.java )
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        // Tell the listView who it needs to listen to
        binding.categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        binding.categoryListView.layoutManager = layoutManager
        binding.categoryListView.setHasFixedSize(true)

        //Used with listView
        /*binding.categoryListView.setOnItemClickListener { adapterView, view, i, l ->
            val category = DataService.categories[i]
            Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()*/


    }
}



