package com.example.recycleview_app_practice.firstrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycleview_app_practice.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animalList = AnimalModel(this).getAnimalList()
        binding.recyclerView.adapter = AnimalAdapter(animalList)
    }
}