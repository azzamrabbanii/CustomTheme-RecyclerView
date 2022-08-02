package com.example.recycleview_app_practice.fourthrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview_app_practice.databinding.ActivityFourthBinding
import com.example.recycleview_app_practice.fourthrecyclerview.data.CategoriesItem
import com.example.recycleview_app_practice.fourthrecyclerview.data.FoodAdapter
import com.example.recycleview_app_practice.fourthrecyclerview.data.FoodResponse
import com.example.recycleview_app_practice.fourthrecyclerview.data.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    var foodResponse = MutableLiveData<FoodResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getFoodListByPage()

        foodResponse.observe(this){
            setupRecyclerView(it.categories)
        }

    }

    private fun setupRecyclerView(categories: List<CategoriesItem?>?) {
        binding.rvFood.apply {
            val fAdapter = FoodAdapter()
            layoutManager = LinearLayoutManager(this@FourthActivity)
            adapter = fAdapter
            fAdapter.setData(categories as List<CategoriesItem>?)
        }
    }

    private fun getFoodListByPage(){
        ApiConfig.getApiService().getFoodList()
            .enqueue(object : Callback<FoodResponse> {
                override fun onResponse(
                    call: Call<FoodResponse>,
                    response: Response<FoodResponse>
                ) {
                    if (response.isSuccessful) foodResponse.postValue(response.body())
                }

                override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                }
            })
    }

}