package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import com.example.proyectopelis.databinding.CeldafrancisBinding


class AdapterPopulares (val listener: OnItemClickListener):
    RecyclerView.Adapter<AdapterPopulares.CeldaHolder>() {

    private val listaPopulares=ArrayList<ResultPopulares?>()

    interface OnItemClickListener{
        fun OnItemClick(resultPopulares: ResultPopulares)
    }

    inner class  CeldaHolder(val binding: CeldafrancisBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=CeldafrancisBinding.inflate(inflater,parent,false)
        return CeldaHolder(binding)
    }

    override fun onBindViewHolder(holder: CeldaHolder, position: Int) {
        val populares: ResultPopulares? =listaPopulares?.get(position)
        holder.binding.nPeli.text=populares?.title
        holder.binding.flanzamiento.text=populares?.releaseDate
        holder.binding.mediaVoto.text=populares?.voteAverage.toString()
        holder.itemView.setOnClickListener {
            if (populares != null) {
                listener.OnItemClick(populares)
            }
        }
        //Glide.with(requireContext).load(populares.posterPath).into(binding.)
    }

    override fun getItemCount(): Int {
        return listaPopulares.size
    }

    fun actualizaLista(lista:List<ResultPopulares?>){
        listaPopulares.clear()
        listaPopulares.addAll(lista)
        notifyDataSetChanged()
    }
}