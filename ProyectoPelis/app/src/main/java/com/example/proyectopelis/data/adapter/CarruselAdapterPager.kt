package com.example.proyectopelis.data.adapter

import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopelis.ViewModel
import com.example.proyectopelis.databinding.HoldercarruseladapterpagerBinding

/*class CarruselAdapterPager(val listaImagenes: List<String>) :
    RecyclerView.Adapter<CarruselAdapterPager.MiCelda>() {

    //private val viewModel by activityViewModels<ViewModel>()

        inner class MiCelda(val binding: HoldercarruseladapterpagerBinding) :
                RecyclerView.ViewHolder(binding.root)

    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiCelda {

    }*/

    override fun getItemCount(): Int {
        return listaImagenes.size
    }

    override fun onBindViewHolder(holder: MiCelda, position: Int) {
        val imagen = listaImagenes[position]
        //viewModel.
    }
}*/