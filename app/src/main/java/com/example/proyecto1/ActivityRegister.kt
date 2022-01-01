package com.example.proyecto1


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONException
import org.json.JSONObject
import kotlin.jvm.Throws


class ActivityRegister : AppCompatActivity() {
    private lateinit var btnpress: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val txtcorreo = findViewById<TextInputEditText>(R.id.txcorreo)
        val txtpassword = findViewById<TextInputEditText>(R.id.txpassword)
        val txtnombres = findViewById<TextInputEditText>(R.id.txnombres)
        val txtcedula = findViewById<TextInputEditText>(R.id.txcedula)
        btnpress=findViewById(R.id.btnreg)
        btnpress.setOnClickListener {
            val correo: String = txtcorreo.text.toString()
            val password: String = txtpassword.text.toString()
            val nombres: String = txtnombres.text.toString()
            val cedula: String = txtcedula.text.toString()
            insertarUser(correo, password, nombres, cedula)
        }

    }

    private fun insertarUser(correo:String, password:String, nombres:String, cedula:String){
        var url:String="http://192.168.200.8/proyecto/insertarUsuario.php"
        var requestQueue:RequestQueue=Volley.newRequestQueue(this)
        var stringRequest:StringRequest=object:StringRequest(Request.Method.POST,url, Response.Listener { response ->
            if (response.trim().equals("Incorrecto")) {
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Usuario Ingresado", Toast.LENGTH_LONG).show()
                val frame1= Intent(this@ActivityRegister,ActivityLogin::class.java)
                startActivity(frame1)
            }
        },Response.ErrorListener {error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        }){
            override fun getParams(): MutableMap<String, String> {
                val params=HashMap<String,String>()
                params.put("Correo",correo)
                params.put("Password",password)
                params.put("Nombres",nombres)
                params.put("Cedula",cedula)
                return params
            }
        }
        requestQueue.add(stringRequest)
    }
}