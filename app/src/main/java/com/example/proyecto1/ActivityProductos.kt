package com.example.proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class ActivityProductos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        val txvista=findViewById<TextView>(R.id.txtconsulta)
        val queue=Volley.newRequestQueue(this)
        val url="http://192.168.200.8/proyecto/listarprueba.php"
        val stringRequest=StringRequest(Request.Method.GET,url, Response.Listener { response ->
            val jsonArray=JSONArray(response)
            for (i in 0 until jsonArray.length()){
                val jsonObject=jsonArray[i]
                txvista.text=jsonObject.toString()
            }
        },Response.ErrorListener { error ->

        })
        queue.add(stringRequest)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}