package com.example.sepatu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.sepatu.details.DetailsPages
import java.util.ArrayList

class ListSepatuAdapt(private val ListSepatu: ArrayList<Sepatu>) : RecyclerView.Adapter<ListSepatuAdapt.ListViewHolder>() {

    class ListViewHolder(ItemView : View) :RecyclerView.ViewHolder(ItemView) {
        val photo :ImageView = ItemView.findViewById(R.id.Image_sepatu)
        val sepatu_name : TextView = ItemView.findViewById(R.id.nama)
        val sepatu_desc : TextView = ItemView.findViewById(R.id.deskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = ListSepatu.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (sepatu_name, sepatu_desc, sepatu_photo) = ListSepatu[position]
        holder.photo.setImageResource(sepatu_photo)
        holder.sepatu_name.text = sepatu_name
        holder.sepatu_desc.text = sepatu_desc
        holder.itemView.setOnClickListener{
            val moveWithDataDetail = Intent(it.context, DetailsPages::class.java)
            moveWithDataDetail.putExtra(DetailsPages.EXTRA_NAME, sepatu_name)
            moveWithDataDetail.putExtra(DetailsPages.EXTRA_DESC, sepatu_desc)
            moveWithDataDetail.putExtra(DetailsPages.EXTRA_PHOTO, sepatu_photo)
            it.context.startActivity(moveWithDataDetail)
        }
    }


}