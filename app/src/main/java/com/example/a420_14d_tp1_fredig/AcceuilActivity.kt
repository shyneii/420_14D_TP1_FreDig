package com.example.a420_14d_tp1_fredig

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class AcceuilActivity : AppCompatActivity(){

    private lateinit var txtAcceuil : TextView
    private lateinit var btnJouer : Button
    private lateinit var btnBanque : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceuil)
        txtAcceuil = findViewById(R.id.txtAcceuil)
        btnJouer = findViewById(R.id.btnJouer)
        btnBanque = findViewById(R.id.btnBanque)
        val sharedPreferences = getSharedPreferences("Comptes", MODE_PRIVATE)
        txtAcceuil.text = "Bonjour ${sharedPreferences.getString("nom", "")}, vous avez ${sharedPreferences.getInt("jetons", 0)} jetons"
        btnJouer.setOnClickListener {
            val intent = intent.setClass(this@AcceuilActivity, RouletteActivity::class.java)
            startActivity(intent)
        }
        btnBanque.setOnClickListener {
            val intent = intent.setClass(this@AcceuilActivity, BanqueActivity::class.java)
            startActivity(intent)
        }
    }
}

