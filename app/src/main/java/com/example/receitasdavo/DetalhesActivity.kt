package com.example.receitasdavo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class DetalhesActivity : AppCompatActivity() {
    private lateinit var imgDetalhe: ImageView
    private lateinit var textDetalheTitulo: TextView
    private lateinit var textTempoDetalhe: TextView
    private lateinit var textReceitaDetalhe: TextView
    private lateinit var buttonVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
        initIDs()
        val bundle = intent.extras
        if (bundle != null){
            val receita = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable("receita", Receita::class.java)
            } else {
                bundle.getParcelable("receita")
            }
            if (receita != null) {
                imgDetalhe.setImageDrawable(ContextCompat.getDrawable(this, receita.resIdimagem))
                textDetalheTitulo.text = receita.titulo
                textTempoDetalhe.text = receita.tempo
                val listaIngredientes = receita.ingredientes
                var textoIngredientes = ""
                for (ingrediente in listaIngredientes){
                    textoIngredientes += "+ $ingrediente \n"
                }
                textReceitaDetalhe.text = textoIngredientes
            }
        }
        buttonVoltar.setOnClickListener { finish() }

    }
  private fun initIDs(){
        imgDetalhe = findViewById(R.id.imgDetalhe)
        textDetalheTitulo = findViewById(R.id.textDetalheTitulo)
        textTempoDetalhe = findViewById(R.id.textTempoDetalhe)
        textReceitaDetalhe = findViewById(R.id.textReceitaDetalhe)
        buttonVoltar = findViewById(R.id.buttonVoltar)

    }
}