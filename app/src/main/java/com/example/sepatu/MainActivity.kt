package com.example.sepatu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sepatu.About.AboutPages

class MainActivity : AppCompatActivity() {

    private lateinit var sepatuList: RecyclerView
    private val list = ArrayList<Sepatu>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        sepatuList = findViewById(R.id.RvSepatu)
        sepatuList.setHasFixedSize(true)

        list.addAll(getSepatu())
        showRecyclerList()

    }

    private fun getSepatu(): ArrayList<Sepatu> {
        val name = resources.getStringArray(R.array.nama_sepatu)
        val deskripsi = resources.getStringArray(R.array.deskripsi_sepatu)
        val photo = resources.obtainTypedArray(R.array.gambar_sepatu)
        val listSepatu = ArrayList<Sepatu>()

        val size = minOf(name.size, deskripsi.size, photo.length())

        for (i in 0 until size) {
            val listSepatuToko = Sepatu(
                name[i],
                deskripsi[i],
                photo.getResourceId(i, -1)
            )
            listSepatu.add(listSepatuToko)
        }

        photo.recycle()
        return listSepatu
    }


    private fun showRecyclerList() {
        sepatuList.layoutManager = LinearLayoutManager(this)
        val listSepatuAdapt = ListSepatuAdapt(list)
        sepatuList.adapter = listSepatuAdapt
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_settings ->{
                val moveWithData = Intent(this@MainActivity,AboutPages::class.java)
                moveWithData.putExtra(AboutPages.EXTRA_NAME,"Gilang Arya Libna")
                moveWithData.putExtra(AboutPages.EXTRA_EMAIL,"gilanglibna@gmail.com")
                moveWithData.putExtra(AboutPages.EXTRA_PHOTO,"gambar2")
                startActivity(moveWithData)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}