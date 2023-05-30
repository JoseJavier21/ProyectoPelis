package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.databinding.CeldafrancisBinding
import java.util.ArrayList


class AdapterEnCines (val listener:OnItemClickListener):
    RecyclerView.Adapter<AdapterEnCines.Celda2Holder>(){

    private val listaEnCines=ArrayList<ResultEnCine?>()

    interface  OnItemClickListener{
        fun OnItemClick(resultEnCine: ResultEnCine)
    }

    inner class Celda2Holder(val binding: CeldafrancisBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Celda2Holder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=CeldafrancisBinding.inflate(inflater,parent,false)
        return Celda2Holder(binding)
    }

    override fun onBindViewHolder(holder: Celda2Holder, position: Int) {
        val enCine=listaEnCines?.get(position)
        holder.binding.nPeli.text=enCine?.title
        holder.binding.flanzamiento.text=enCine?.releaseDate
        holder.binding.mediaVoto.text=enCine?.voteAverage.toString()
        holder.itemView.setOnClickListener {
            if (enCine != null) {
                listener.OnItemClick(enCine)
            }
        }
    }

    override fun getItemCount(): Int {
       return listaEnCines.size
    }

    fun actualizaLista2(lista: List<ResultEnCine?>){
        listaEnCines.clear()
        listaEnCines.addAll(lista)
        notifyDataSetChanged()
    }
}

