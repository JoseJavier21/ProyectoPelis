package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectopelis.R
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

        val rated: ResultRated = copiaLista.get(position)
        val context = holder.itemView.context
        holder.binding.nombrePeli.text = rated.title
        holder.binding.puntuacion.text = rated.voteAverage.toString()
        holder.binding.idioma.text = rated.originalLanguage
        //Glide.with(context).load(rated.posterPath).placeholder(R.drawable.ic_launcher_background).into(R.id.imgpeli)
        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(R.id.action_topRated_to_fragmentPelisDetalles)
        }
    }

    fun updateRated(lista: List<ResultRated>){
        listaOriginal.clear()
        listaOriginal.addAll(lista)
        copiaLista.clear()
        copiaLista.addAll(lista)
        notifyDataSetChanged()

    }
}