package com.example.recycleview_app_practice.fourthrecyclerview.data.network

import com.example.recycleview_app_practice.fourthrecyclerview.data.FoodResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    fun getFoodList()
    :Call<FoodResponse>
}