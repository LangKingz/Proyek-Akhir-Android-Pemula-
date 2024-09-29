package com.example.sepatu.About

import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sepatu.R
import org.w3c.dom.Text

class AboutPages : AppCompatActivity() {

    private lateinit var toolBar : Toolbar
    private lateinit var BtnBack: ImageButton

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about_pages)

        BtnBack = findViewById(R.id.back)
        BtnBack.setOnClickListener{
            finish()
        }

        val dataNama : TextView = findViewById(R.id.nama)
        val dataEmail : TextView = findViewById(R.id.email)
        val photo : ImageView = findViewById(R.id.imageView)

        val name = intent.getStringExtra(EXTRA_NAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val photoName = intent.getStringExtra(EXTRA_PHOTO)

        dataNama.text = name
        dataEmail.text = email
        photo.setImageResource(resources.getIdentifier(photoName,"drawable",packageName))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return false
    }
}