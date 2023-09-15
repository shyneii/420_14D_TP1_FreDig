package com.example.a420_14d_tp1_fredig

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class BanqueActivity : AppCompatActivity(){

    private lateinit var btnDeposer : Button
    private lateinit var edTxtDeposer : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banque)
        val btnDeposer = findViewById<Button>(R.id.btnDeposer)
        var edTxtDeposer = findViewById<EditText>(R.id.edTxtDeposer)
        btnDeposer.setOnClickListener {
            val sharedPreferences = getSharedPreferences("Comptes", MODE_PRIVATE)
            val jetons = sharedPreferences.getInt("jetons", 0)
            val editor = sharedPreferences.edit()
            var jetonsApresDepot = jetons + edTxtDeposer.text.toString().toInt()
            editor.putInt("jetons", jetonsApresDepot)
            editor.apply()
            intent = Intent(this@BanqueActivity, AcceuilActivity::class.java)
            startActivity(intent)
        }
    }
}

