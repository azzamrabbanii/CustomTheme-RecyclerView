package com.example.recycleview_app_practice.cakejsondata

data class ModelCake (
   var id: String = "",
   var type: String? = null,
   val batters: Batter
)

data class Batter (
    val batter: ArrayList<BatterItem>
)

class BatterItem (
    var id: String = "",
    var type: String? = null
)
