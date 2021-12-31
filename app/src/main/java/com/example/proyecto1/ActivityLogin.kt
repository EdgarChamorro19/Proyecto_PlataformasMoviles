package com.example.proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputEditText

class ActivityLogin : AppCompatActivity() {
    private lateinit var btnlogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val txtcorreo=findViewById<TextInputEditText>(R.id.txtemail)
        val txtpassword=findViewById<TextInputEditText>(R.id.txtpassword)
        btnlogin=findViewById(R.id.btningreso)
        btnlogin.setOnClickListener{
            val correo:String=txtcorreo.text.toString()
            val password:String=txtpassword.text.toString()
            loginRequest(correo,password)
        }
    }
    private fun loginRequest(correo:String, password:String){
        var url:String="http://192.168.200.8/proyecto/login.php";
        var requestQueue:RequestQueue=Volley.newRequestQueue(this)
        var stringRequest:StringRequest=object:StringRequest(Method.POST,url, Response.Listener { response ->
            if (response.trim().equals("correcto")) {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show()
                val frame1= Intent(this@ActivityLogin,ActivityPrincipal::class.java)
                startActivity(frame1)
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
            }
        },Response.ErrorListener {error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        }){
            override fun getParams(): MutableMap<String, String> {
                val params=HashMap<String,String>()
                params.put("Correo",correo)
                params.put("Password",password)
                return params
            }
        }
        requestQueue.add(stringRequest)
    }
}