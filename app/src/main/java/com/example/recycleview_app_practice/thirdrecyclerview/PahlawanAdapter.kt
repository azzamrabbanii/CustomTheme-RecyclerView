package com.example.recycleview_app_practice.thirdrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleview_app_practice.databinding.PahlawanItemBinding

class PahlawanAdapter(val listPahlawan: MutableList<ModelPahlawan>): RecyclerView.Adapter<PahlawanAdapter.PahlawanViewHolder>() {

    class PahlawanViewHolder(val itemPahlawan: PahlawanItemBinding): RecyclerView.ViewHolder(itemPahlawan.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PahlawanViewHolder(
        PahlawanItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PahlawanViewHolder, position: Int) {
        holder.itemPahlawan.apply {
            with(listPahlawan[position]){
                tvNamaPahlawan.text = nama
                tvNamaLengkap.text = namaLengkap
                Glide.with(imagePahlawan.context).load(image).into(imagePahlawan)
            }
        }
    }

    override fun getItemCount(): Int {
        return listPahlawan.size
    }
}