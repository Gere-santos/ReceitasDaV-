package com.example.receitasdavo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvReceitas : RecyclerView
    private lateinit var receitasAdapter: ReceitasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvReceitas = findViewById(R.id.rvReceitas)





        val lista = listOf(Receita("Escondidinho de Camarão", "25 min", R.drawable.carne1,
            listOf("1KG de camarão", "Manteiga", "Alho", "Cebola")),
            Receita("Rocambole de carne moída", "15 min", R.drawable.carne3,
                listOf("Carne a vontade", "Alho", "Cebola")),
            Receita("Panqueca de carne moída", "1h ", R.drawable.carne2,
                listOf("1KG de Carne", "Alho", "Cebola")),
            Receita("Escondidinho de carne seca", "45 min", R.drawable.carne4,
                listOf("1KG de carne seca", "Manteiga", "Batata", "Cebola", "Creme de leite", "Mussarela")),)

        receitasAdapter = ReceitasAdapter{ receita ->
            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("receita", receita)
            startActivity(intent)
        }
        rvReceitas.adapter = receitasAdapter
        receitasAdapter.configurarLista(lista)
        rvReceitas.layoutManager  = LinearLayoutManager(this)
    }
}