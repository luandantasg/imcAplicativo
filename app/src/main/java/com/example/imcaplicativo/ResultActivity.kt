package com.example.imcaplicativo

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val classificacao: String
        val corTexto: Int

        if (result <= 18.5f) {
            classificacao = "MAGREZA"
            corTexto = ContextCompat.getColor(this, R.color.magreza_color)
        } else if (result <= 24.9f) {
            classificacao = "NORMAL"
            corTexto = ContextCompat.getColor(this, R.color.normal_color)
        } else if (result <= 29.9f) {
            classificacao = "SOBREPESO 1"
            corTexto = ContextCompat.getColor(this, R.color.sobrepeso_color)
        } else if (result <= 39.9f) {
            classificacao = "OBESIDADE"
            corTexto = ContextCompat.getColor(this, R.color.obesidade_color)
        } else {
            classificacao = "OBESIDADE GRAVE"
            corTexto = ContextCompat.getColor(this, R.color.obesidade_grave_color)
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(corTexto)


    }
}