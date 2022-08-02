package com.example.recycleview_app_practice.fourthrecyclerview.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleview_app_practice.databinding.FoodItemBinding

class FoodAdapter(): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    var listFood = ArrayList<CategoriesItem>()

    class FoodViewHolder(val binding: FoodItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FoodViewHolder (
        FoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.binding.apply {
            tvName.text = listFood[position].strCategory
            Glide.with(holder.itemView.context)
                .load(listFood[position].strCategoryThumb)
                .into(imgView)
        }
    }

    override fun getItemCount() = listFood.size

    fun setData(list: List<CategoriesItem>?) {
        if (list == null) return
        this.listFood.clear()
        this.listFood.addAll(list)
    }
}