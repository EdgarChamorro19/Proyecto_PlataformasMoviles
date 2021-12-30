package com.example.proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityLogin : AppCompatActivity() {
    private lateinit var btnlogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnlogin=findViewById(R.id.btningreso)
        btnlogin.setOnClickListener{
            val frame1= Intent(this@ActivityLogin,ActivityPrincipal::class.java)
            startActivity(frame1)
        }
    }
}