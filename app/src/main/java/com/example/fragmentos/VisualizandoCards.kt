package com.example.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VisualizandoCards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_visualizando_cards)
        val controladorDeCards = findViewById<LinearLayout>(R.id.controladorCards)
        val inflamar = LayoutInflater.from(this)
        val listaDeProdutos = listOf(
            arrayOf("https://www.notebookcheck.info/fileadmin/Notebooks/News/_nc5/Hollow-Knight-Silksong-6-million-copies-sold.jpg", "Jogos", "Descriçao"),
            arrayOf("https://www.notebookcheck.info/fileadmin/Notebooks/News/_nc5/Hollow-Knight-Silksong-6-million-copies-sold.jpg", "Jogos", "Descriçao")
        )
        for(elemento in listaDeProdutos){
            val Card = inflamar.inflate(R.layout.card, controladorDeCards, false)
            val titulo = Card.findViewById<TextView>(R.id.txtNome)
            val descricao = Card.findViewById<TextView>(R.id.txtDescricao)
            titulo.text = elemento[1]
            descricao.text = elemento[2]
            controladorDeCards.addView(Card)
        }
    }
}