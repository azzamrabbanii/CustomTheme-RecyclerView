package com.example.recycleview_app_practice.thirdrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview_app_practice.R
import com.example.recycleview_app_practice.databinding.ActivityThirdBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets

class ThirdActivity : AppCompatActivity() {

    private var modelPahlawan: MutableList<ModelPahlawan> = ArrayList()
    lateinit var pahlawanAdapter: PahlawanAdapter

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getListPahlawan()
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        binding.rvPahlawan.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ThirdActivity)
            adapter = pahlawanAdapter
        }
    }

    fun getListPahlawan(){
        try {
            // proses membuka asset json dengan kotlin
            val stream = assets.open("pahlawan_nasional.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            val strContext = String(buffer, StandardCharsets.UTF_8)
            try {
                val jsonObject = JSONObject(strContext)
                // cara memangil jsonArray di jsonObject
                val jsonArray = jsonObject.getJSONArray("daftar_pahlawan")
                for (i in 0 until  jsonArray.length()){
                    val jsonObjectData = jsonArray.getJSONObject(i)
                    val dataApi = ModelPahlawan()
                    dataApi.nama = jsonObjectData.getString("nama")
                    dataApi.namaLengkap = jsonObjectData.getString("nama2")
                    dataApi.image = jsonObjectData.getString("img")
                    modelPahlawan.add(dataApi)
                }
                pahlawanAdapter = PahlawanAdapter(modelPahlawan)
            }catch (e : JSONException){
                // Log.e("ERROR", e.toString())
                e.printStackTrace()
            }
        }catch (e : IOException){
            Toast.makeText(this, "error!!! try again", Toast.LENGTH_SHORT).show()
        }
    }

}