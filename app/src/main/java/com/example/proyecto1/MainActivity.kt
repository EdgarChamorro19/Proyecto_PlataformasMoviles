package com.example.proyecto1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnlogin: Button
    private lateinit var btnregistro: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)
        setTheme(R.style.Theme_Proyecto2)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnregistro=findViewById(R.id.btnregistro)
        btnlogin=findViewById(R.id.btnlogin)
        btnlogin.setOnClickListener{
            val frm1= Intent(this@MainActivity,ActivityLogin::class.java)
            startActivity(frm1)
        }
        btnregistro.setOnClickListener{
            val frm2= Intent(this@MainActivity,ActivityRegister::class.java)
            startActivity(frm2)
        }
    }
}