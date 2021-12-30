package com.example.proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.proyecto1.databinding.ActivityRegisterBinding

class ActivityRegister : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityRegisterBinding.inflate(layoutInflater)

        binding.btnreg.setOnClickListener{
            val cedula= binding.txtcedula.editText?.text.toString()
            Toast.makeText(this,"cedula -> $cedula", Toast.LENGTH_LONG).show()
        }
        setContentView(binding.root)

    }
}