package com.example.fragmentos

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 600 && resultCode == RESULT_OK) {
            val imagemCamera = findViewById<ImageView>(R.id.imgPerfil)
            val imagemParaAndroid = data?.extras?.get("data") as? Bitmap
            imagemCamera.setImageBitmap(imagemParaAndroid)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.hide() //Esconde a barra de navegação superior
        val fragmento = Termo() //Obtem o novo elemento
        fragmento.show(supportFragmentManager, "AlertFragmento") //Renderiza o elemento
        val imagemPerfil = findViewById<ImageView>(R.id.imgPerfil)
        Glide.with(this)
            .load("https://space4games.com/wp-content/uploads/Hollow-Knight_-Silksong-Cover.jpg")
            .into(imagemPerfil)

        var tem = false
        if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                tem = true
            }
        else
            requestPermissions(arrayOf(Manifest.permission.CAMERA), 400)

        val btnAlterar = findViewById<Button>(R.id.btnAlterar)
        btnAlterar.setOnClickListener {
            if (tem) {
                val intencao = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intencao, 600)
            } else {
                Toast.makeText(this, "Você não autorizou o uso da câmera", Toast.LENGTH_LONG).show()
            }
        }
        val fabCards = findViewById<FloatingActionButton>(R.id.fabCards)
        fabCards.setOnClickListener {
            val intensao = Intent(this, VisualizandoCards::class.java)
            startActivity(intensao)
        }
    }
}