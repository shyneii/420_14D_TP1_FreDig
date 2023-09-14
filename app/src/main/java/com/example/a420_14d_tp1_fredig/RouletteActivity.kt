package com.example.a420_14d_tp1_fredig

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class RouletteActivity : AppCompatActivity(){

    private lateinit var btnJouerRoulette : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette)
        btnJouerRoulette = findViewById(R.id.btnJouerRoulette)
        btnJouerRoulette.setOnClickListener {
            //avoir le montant de jetons
            val sharedPreferences = getSharedPreferences("Comptes", MODE_PRIVATE)
            val jetons = sharedPreferences.getInt("jetons", 0)
            //si le montant de jetons est plus grand que 0
            if (jetons > 0 ){
                val editor = sharedPreferences.edit()
                editor.putInt("jetons", jetons - 1)
            }
        }
    }
}

