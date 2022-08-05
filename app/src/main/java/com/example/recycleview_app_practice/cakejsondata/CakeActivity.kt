package com.example.recycleview_app_practice.cakejsondata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview_app_practice.databinding.ActivityCakeBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class CakeActivity : AppCompatActivity() {

    private var modelCake = mutableListOf<BatterItem>()

    private var _binding: ActivityCakeBinding? = null
    private val binding get() = _binding as ActivityCakeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityCakeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getModelCake
        getModelCake()
        // setUp Adapter
        val cakeAdapter = CakeAdapter(modelCake)
        binding.rvCake.adapter = cakeAdapter
        // setUp LayoutManager
        binding.rvCake.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CakeActivity)
        }

    }

    fun getModelCake(){
        val json = getJSONObject()
        try {
            val getRootJson = JSONArray(json)
            for (i in 0 until getRootJson.length()){
                val jsonObjectData = getRootJson.getJSONObject(i)
                val getBatters = jsonObjectData.getJSONObject("batters")
                val getBatter = getBatters.getJSONArray("batter")
                for (u in 0 until getBatter.length()){
                    val batterItem = getBatter.getJSONObject(u)
                    val dataJson = BatterItem(
                        id = batterItem.getString("id"),
                        type = batterItem.getString("type")
                    )
                    modelCake.add(dataJson)
                }
            }
        }catch (e: JSONException){
            Log.e("TAg", "getModelCake : $e",)
        }
    }

    private fun getJSONObject(): String?{
        val str : String
        try {
            str = assets.open("cake.json").bufferedReader().use { it.readText() }
        }
        catch (e: IOException){
            Log.e("TAG", "getJSONObject: $e",)
            return null
        }
        return str
    }


}