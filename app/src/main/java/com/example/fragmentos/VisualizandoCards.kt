package com.example.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

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
            val card = inflamar.inflate(R.layout.card, controladorDeCards, false)
            val imagem = card.findViewById<ImageView>(R.id.imgCard)
            val titulo = card.findViewById<TextView>(R.id.txtNome)
            val descricao = card.findViewById<TextView>(R.id.txtDescricao)
            Glide.with(this)
                .load(elemento[0])
                .into(imagem)
            titulo.text = elemento[1]
            descricao.text = elemento[2]
            controladorDeCards.addView(card)
        }
    }
}