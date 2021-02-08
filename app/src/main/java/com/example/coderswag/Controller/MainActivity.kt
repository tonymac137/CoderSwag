package com.example.coderswag.Controller

// Kotlin for Android Beginner to Advanced
// Udemy
// Started 07/02/2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.coderswag.Adapters.CategoryAdapter
import com.example.coderswag.Model.Category
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Initialise the Adapter for the listView - using Model.Category
    lateinit var adapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Create the Adapter for the listView
        adapter = CategoryAdapter(this, DataService.categories)


        // Tell the listView who it needs to listen to
        binding.categoryListView.adapter = adapter

    }



}