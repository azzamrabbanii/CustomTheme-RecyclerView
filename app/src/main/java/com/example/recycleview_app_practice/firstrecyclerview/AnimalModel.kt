package com.example.recycleview_app_practice.firstrecyclerview

import android.content.Context
import com.example.recycleview_app_practice.R

class AnimalModel(val context: Context) {
    fun getAnimalList(): Array<String>{
        return context.resources.getStringArray(R.array.animal_list)
    }
}