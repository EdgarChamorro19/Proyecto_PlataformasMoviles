package com.example.proyecto1

import android.content.Context
import android.content.pm.ActivityInfo
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.proyecto1.databinding.ActivityRegisterBinding
import org.json.JSONException
import org.json.JSONObject


class ActivityRegister : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityRegisterBinding.inflate(layoutInflater)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val conexion = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val status = conexion.getActiveNetwork()

        binding.btnreg.setOnClickListener{
            if (status != null) {
                addUser()
                //Toast.makeText(this, "RSI", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Revise su conexion a internet", Toast.LENGTH_LONG).show()
            }
        }
        setContentView(binding.root)

    }

    private fun addUser(){
        val email=binding.txtcorreo.editText?.text.toString()
        val contraseña=binding.txtpassword.editText?.text.toString()

        val url = "http://192.168.200.8/ejemplo/save.php"

        //creating volley string request
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                try {
                    val obj = JSONObject(response)
                    Toast.makeText(applicationContext, obj.getString("message"), Toast.LENGTH_LONG).show()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { volleyError -> Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show() }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params.put("Nombre", "edgar")
                params.put("Apellido", "edgar")
                return params
            }
        }
        val queue = Volley.newRequestQueue(this)
        //adding request to queue
        queue.add(stringRequest)

    }
}