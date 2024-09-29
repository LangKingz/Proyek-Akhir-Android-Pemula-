package com.example.sepatu.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sepatu.R

class DetailsPages : AppCompatActivity() {

    private lateinit var btnBack : ImageButton
    private lateinit var btnShare : Button

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details_pages)

        btnBack = findViewById(R.id.back_detail)
        btnBack.setOnClickListener{
            finish()
        }

        val dataTitle :TextView = findViewById(R.id.title)
        val dataDesc :TextView = findViewById(R.id.deskripsi_detail)
        val dataPhoto :ImageView = findViewById(R.id.image_detail)

        val title = intent.getStringExtra(EXTRA_NAME)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val photo = intent.getIntExtra(EXTRA_PHOTO,0)

        dataTitle.text = title
        dataDesc.text = desc
        dataPhoto.setImageResource(photo)

        btnShare = findViewById(R.id.action_share)
        btnShare.setOnClickListener{
            val imageUrl = Uri.parse("android.resource://$packageName/drawable/$photo")

            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Sepatu $title kurasa sangat cocok dengan mu")
                putExtra(Intent.EXTRA_STREAM, imageUrl)
                type = "image/jpeg"
            }

            startActivity(Intent.createChooser(shareIntent, "Share to:"))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return false
    }

}