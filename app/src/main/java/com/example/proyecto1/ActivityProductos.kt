package com.example.proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_productos.*
import org.json.JSONArray
import org.json.JSONObject

class ActivityProductos : AppCompatActivity() {
    val arrayList=ArrayList<Productos>()
    val displayList=ArrayList<Productos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        val url = "http://192.168.200.8/proyecto/listarProductos.php"
        val queue=Volley.newRequestQueue(this)
        val stringRequest=StringRequest(Request.Method.GET,url,{ response ->

            val jsonArray=JSONArray(response)

            for (i in 0 until jsonArray.length()){
                val jsonObject=JSONObject(jsonArray.getString(i))
                val id=jsonObject.get("id").toString().toInt()
                val nombre=jsonObject.get("Nombre").toString()
                val cantidad=jsonObject.get("Cantidad").toString().toInt()
                val categoria=jsonObject.get("Categoria").toString()
                val valor=jsonObject.get("Valor").toString().toDouble()
                val imagen=jsonObject.get("imagen").toString()

                arrayList.add(Productos(id,nombre,cantidad,categoria,valor,imagen))
            }

            displayList.addAll(arrayList)

            val myAdapter=MyAdapter(displayList,this)
            recyclerView.layoutManager=LinearLayoutManager(this)
            recyclerView.adapter=myAdapter
        },{ error ->
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        })
        queue.add(stringRequest)

    }

    /*fun getProductos(){
        val url = "http://192.168.200.8/proyecto/listarprueba.php"
        val stringRequest=StringRequest(Request.Method.GET,url,Response.Listener { response -> parseData(response)
        },
        Response.ErrorListener { error ->
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
        })

        val req=Volley.newRequestQueue(this)
        req.add(stringRequest)
    }

    fun parseData(response:String){
        val arrayJson=JSONArray(response)

        for (i in 0..arrayJson.length()-1){
            val currentObject= arrayJson.getJSONObject(i)

            val producto=Productos(currentObject.getInt("id"),
                                    currentObject.getString("Nombre"),
                                    currentObject.getInt("Cantidad"),
                                    currentObject.getString("Categoria"),
                                    currentObject.getDouble("Valor"))
            productos?.add(producto)
        }
    }
    fun onConsultar(){
        val url="http://192.168.200.8/proyecto/listarprueba.php"
        val stringRequest=object:StringRequest(Request.Method.GET,url,Response.Listener { response ->
            try {
                val jsonObj=JSONObject(response)
                val objArray=jsonObj.getJSONArray("productos")

                for (i in 0 until objArray.length()){

                }
            }catch (e:JSONException){

            }
        },Response.ErrorListener { error ->
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
        }){ }
        val queue=Volley.newRequestQueue(this)
        queue.add(stringRequest)
    }
    override fun onBackPressed() {
        super.onBackPressed()
    }
    */
}