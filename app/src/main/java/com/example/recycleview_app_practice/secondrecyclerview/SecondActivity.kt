package com.example.recycleview_app_practice.secondrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview_app_practice.R
import com.example.recycleview_app_practice.databinding.ActivityMainBinding
import com.example.recycleview_app_practice.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val carList = carModel.listCar
        binding.rvCar.adapter = CarAdapter(carList)
        binding.rvCar.layoutManager = LinearLayoutManager(this)
    }
}