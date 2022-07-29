package com.example.recycleview_app_practice.secondrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleview_app_practice.databinding.CarItemBinding

class CarAdapter(private val carList: ArrayList<DataCar>):
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    inner class CarViewHolder(val itemBinding: CarItemBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemBinding = CarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CarAdapter.CarViewHolder, position: Int) {
       holder.itemBinding.apply {
           with(carList[position]){
               txtView.text = title
               Glide.with(imgView.context).load(picture).into(imgView)
           }
       }

    }

    override fun getItemCount(): Int {
        return carList.size
    }

}