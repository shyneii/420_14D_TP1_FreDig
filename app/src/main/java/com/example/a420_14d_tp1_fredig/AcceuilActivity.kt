package com.example.a420_14d_tp1_fredig

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.widget.Toast
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
        txtAcceuil.text = "${getString(R.string.accueil1)} ${sharedPreferences.getString("nom", "")}, ${getString(R.string.accueil2)} ${sharedPreferences.getInt("jetons", 0)} ${getString(R.string.accueil3)}"

        btnJouer.setOnClickListener {
            if (sharedPreferences.getInt("jetons", 0) <= 0) {
                Toast.makeText(this, "${getString(R.string.jetonsManquant)}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@AcceuilActivity, BanqueActivity::class.java)
                startActivity(intent)
            }
            else{
                val intent = Intent(this@AcceuilActivity, RouletteActivity::class.java)
                startActivity(intent)
            }
        }
        btnBanque.setOnClickListener {
            val intent = Intent(this@AcceuilActivity, BanqueActivity::class.java)
            startActivity(intent)
        }
    }
}

