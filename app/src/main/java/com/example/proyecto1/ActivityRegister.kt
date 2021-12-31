package com.example.proyecto1

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.PackageManagerCompat
import androidx.core.content.PackageManagerCompat.LOG_TAG
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
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
        binding.btnreg.setOnClickListener {
            val email = binding.txtcorreo.editText?.text.toString()
            val contraseña = binding.txtpassword.editText?.text.toString()
            Toast.makeText(this, "correo->$email, contraseña->$contraseña", Toast.LENGTH_LONG).show()
        }
        setContentView(binding.root)

    }

}