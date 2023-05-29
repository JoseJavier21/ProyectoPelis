package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopelis.data.network.TopRated.ResultRated
import com.example.proyectopelis.databinding.CeldaratedBinding

class AdapterRated: RecyclerView.Adapter<AdapterRated.CeldaRated>() {

    private val listaOriginal = ArrayList<ResultRated>()
    private val copiaLista = ArrayList<ResultRated>()

    inner class CeldaRated(val binding: CeldaratedBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaRated {

        val inflater = LayoutInflater.from(parent.context)
        val binding = CeldaratedBinding.inflate(inflater, parent, false)
        return CeldaRated(binding)
    }

    override fun getItemCount(): Int {
        return listaOriginal.size
    }

    override fun onBindViewHolder(holder: CeldaRated, position: Int) {

        val peli: ResultRated = copiaLista.get(position)
        holder.binding.nombrePeli.text = peli.title
        holder.binding.puntuacion.text = peli.voteAverage.toString()
        holder.binding.idioma.text = peli.originalLanguage
        holder.itemView.setOnClickListener {
            // holder.itemView.findNavController().navigate(R.id) al pinchar sobre la celda que te lleve a otro fragment con toda la informacion
        }
    }

    fun actualizar(lista: List<ResultRated>){
        listaOriginal.clear()
        listaOriginal.addAll(lista)
        copiaLista.clear()
        copiaLista.addAll(lista)
        notifyDataSetChanged()

    }
}