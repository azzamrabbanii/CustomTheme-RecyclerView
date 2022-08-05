package com.example.recycleview_app_practice.cakejsondata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview_app_practice.databinding.CakeItemBinding

class CakeAdapter(private val listCake: MutableList<BatterItem>): RecyclerView.Adapter<CakeAdapter.CakeViewHolder>() {

    class CakeViewHolder(val itemCake: CakeItemBinding): RecyclerView.ViewHolder(itemCake.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CakeViewHolder(
        CakeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        holder.itemCake.apply {
            with(listCake[position]){
                tvId.text = id
                tvType.text = type
            }
        }
    }

    override fun getItemCount(): Int {
        return listCake.size
    }
}