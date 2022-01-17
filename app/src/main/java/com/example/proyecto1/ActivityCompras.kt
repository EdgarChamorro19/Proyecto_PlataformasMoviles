package com.example.proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_compras.*
import kotlinx.android.synthetic.main.activity_productos.*
import org.json.JSONArray
import org.json.JSONObject

class ActivityCompras : AppCompatActivity() {
    val arrayList=ArrayList<Compras>()
    val displayList=ArrayList<Compras>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compras)

        val url = "http://192.168.200.8/proyecto/listarCompras.php"
        val queue= Volley.newRequestQueue(this)
        val stringRequest= StringRequest(Request.Method.GET,url,{ response ->

            val jsonArray= JSONArray(response)

            for (i in 0 until jsonArray.length()){
                val jsonObject= JSONObject(jsonArray.getString(i))
                val idcompras=jsonObject.get("id").toString().toInt()
                val nombrecliente=jsonObject.get("nombrecliente").toString()
                val identificacioncliente=jsonObject.get("identificacioncliente").toString()
                val nombreproducto=jsonObject.get("nombreproducto").toString()
                val cantidadproducto=jsonObject.get("cantidadproducto").toString().toInt()
                val estado=jsonObject.get("estado").toString()
                val correocliente=jsonObject.get("correocliente").toString()

                arrayList.add(Compras(idcompras, nombrecliente, identificacioncliente, nombreproducto, cantidadproducto, estado, correocliente))
            }

            displayList.addAll(arrayList)

            val comprasAdapter=ComprasAdapter(displayList,this)
            comprasview.layoutManager= LinearLayoutManager(this)
            comprasview.adapter=comprasAdapter
        },{ error ->
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        })
        queue.add(stringRequest)
    }
}