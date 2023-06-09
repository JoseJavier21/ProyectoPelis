package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectopelis.databinding.HoldercarruseladapterpagerBinding

class CarruselAdapterPager(val listaImagenes: List<String>) :
    RecyclerView.Adapter<CarruselAdapterPager.MiCelda>() {

        inner class MiCelda(val binding: HoldercarruseladapterpagerBinding) :
                RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiCelda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HoldercarruseladapterpagerBinding.inflate(layoutInflater, parent, false)
        return MiCelda(binding)
    }

    override fun getItemCount(): Int {
        return listaImagenes.size
    }

    override fun onBindViewHolder(holder: MiCelda, position: Int) {
        val imagen = listaImagenes[position]
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/original$imagen")
            .into(holder.binding.carruselgrande)
    }
}