package com.example.recycleview_app_practice.fourthrecyclerview.data

import com.google.gson.annotations.SerializedName

data class FoodResponse(

	@field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null
)

data class CategoriesItem(

	@field:SerializedName("strCategory")
	val strCategory: String? = null,

	@field:SerializedName("strCategoryDescription")
	val strCategoryDescription: String? = null,

	@field:SerializedName("idCategory")
	val idCategory: String? = null,

	@field:SerializedName("strCategoryThumb")
	val strCategoryThumb: String? = null
)
