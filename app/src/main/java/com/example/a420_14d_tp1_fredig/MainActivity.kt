package com.example.a420_14d_tp1_fredig

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    private lateinit var btnConnecter: Button
    private lateinit var edTxtNom : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnConnecter = findViewById(R.id.btnConnecter)
        edTxtNom = findViewById(R.id.edTxtNom)
        val sharedPreferences = getSharedPreferences("Comptes", MODE_PRIVATE)
        btnConnecter.setOnClickListener {
            if (edTxtNom.text.toString().isEmpty()) {
                edTxtNom.error = "Veuillez entrer votre nom"
                return@setOnClickListener
            }
            else{
                if (!sharedPreferences.contains(edTxtNom.text.toString())) {
                    val editor = sharedPreferences.edit()
                    editor.putString("nom", edTxtNom.text.toString())
                    editor.putInt("jetons", 15)
                    editor.apply()
                }

            }
            val intent = Intent(this@MainActivity, AcceuilActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
