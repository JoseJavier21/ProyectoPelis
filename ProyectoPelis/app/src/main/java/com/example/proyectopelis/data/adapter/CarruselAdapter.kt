package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectopelis.data.network.Imagenes.Poster
import com.example.proyectopelis.databinding.HoldercarruseladapterBinding

class CarruselAdapter() :
    RecyclerView.Adapter<CarruselAdapter.MyViewHolder>() {

        private val dataList = ArrayList<Poster>()
        private val dataListPoster: MutableList<Poster> = mutableListOf()
        private var onItemClickListener: ((Poster) -> Unit)? = null

        inner class MyViewHolder(val binding: HoldercarruseladapterBinding) :
                RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HoldercarruseladapterBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val carrusel = dataList[position]
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/original${carrusel.file_path}")
            .into(holder.binding.carruselfoto)
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(carrusel)
        }
    }

    fun setOnItemClickListener(listener: (Poster) -> Unit) {
        onItemClickListener = listener
    }

    fun getPosition(poster: Poster): Int {
        return dataListPoster.indexOf(poster)
    }

    fun update(list: MutableList<Poster>) {
    dataList.clear()
    dataList.addAll(list)
    notifyDataSetChanged()
     }
}