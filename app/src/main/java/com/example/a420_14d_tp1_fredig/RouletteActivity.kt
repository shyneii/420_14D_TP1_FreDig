package com.example.a420_14d_tp1_fredig

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlin.random.Random


class RouletteActivity : AppCompatActivity() {

    private lateinit var btnJouerRoulette: Button
    private lateinit var edTxtMise: EditText
    private lateinit var edTxtNumero: EditText
    private lateinit var radioPaire: RadioButton
    private lateinit var radioImpaire: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette)
        val sharedPreferences = getSharedPreferences("Comptes", MODE_PRIVATE)
        btnJouerRoulette = findViewById(R.id.btnJouerRoulette)
        edTxtMise = findViewById(R.id.edTxtMise)
        edTxtNumero = findViewById(R.id.edTxtNumero)
        radioPaire = findViewById(R.id.radioPaire)
        radioImpaire = findViewById(R.id.radioImpaire)
        edTxtNumero.doAfterTextChanged {
            if (!edTxtNumero.text.toString().isEmpty()) {
                radioPaire.isEnabled = false
                radioImpaire.isEnabled = false
            }
            else
            {
                radioPaire.isEnabled = true
                radioImpaire.isEnabled = true
            }
        }
        btnJouerRoulette.setOnClickListener {
            if (edTxtMise.text.toString().isEmpty()) {
                edTxtMise.error = getString(R.string.miseManquante)
                return@setOnClickListener
            }
            if (edTxtNumero.text.toString().isEmpty() && !radioPaire.isChecked && !radioImpaire.isChecked) {
                edTxtNumero.error = getString(R.string.erreurRoulette)
                return@setOnClickListener
            }
            if (sharedPreferences.getInt("jetons", 0) < edTxtMise.text.toString().toInt()) {
                val intent = Intent(this@RouletteActivity, BanqueActivity::class.java)
                startActivity(intent)
            }
            else{
                var mise = edTxtMise.text.toString().toInt()
                var numero = 0
                if (!edTxtNumero.text.toString().isEmpty()){
                    numero = edTxtNumero.text.toString().toInt()
                }
                val random = Random.nextInt(37)
                if (radioImpaire.isChecked || radioPaire.isChecked){
                    if ((radioPaire.isChecked && random % 2 == 0) || (radioImpaire.isChecked && random % 2 != 0)){
                        var jetons = sharedPreferences.getInt("jetons", 0)
                        jetons -= mise
                        jetons += mise * 2
                        val editor = sharedPreferences.edit()
                        editor.putInt("jetons", jetons)
                        editor.apply()
                        Toast.makeText(this, "${random} gagné", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        var jetons = sharedPreferences.getInt("jetons", 0)
                        jetons -= mise
                        val editor = sharedPreferences.edit()
                        editor.putInt("jetons", jetons)
                        editor.apply()
                        Toast.makeText(this, "${random} perdu", Toast.LENGTH_SHORT).show()
                    }
                }
                else if (numero == random && !edTxtNumero.text.toString().isEmpty()){
                    var jetons = sharedPreferences.getInt("jetons", 0)
                    jetons -= mise
                    jetons += mise * 36
                    val editor = sharedPreferences.edit()
                    editor.putInt("jetons", jetons)
                    editor.apply()
                    Toast.makeText(this, "${random} gagné", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    var jetons = sharedPreferences.getInt("jetons", 0)
                    jetons -= mise
                    val editor = sharedPreferences.edit()
                    editor.putInt("jetons", jetons)
                    editor.apply()
                    Toast.makeText(this, "${random} perdu", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

