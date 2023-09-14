package com.example.a420_14d_tp1_fredig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(){

    private lateinit var btnConnecter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConnecter = findViewById(R.id.btnConnecter)
        btnConnecter.setOnClickListener {
            val intent = Intent(this@MainActivity, AcceuilActivity::class.java)
            startActivity(intent)
        }
    }
}
