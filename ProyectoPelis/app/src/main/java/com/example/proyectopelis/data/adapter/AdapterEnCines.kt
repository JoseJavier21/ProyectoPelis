package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import com.example.proyectopelis.databinding.CeldapopularesBinding


class AdapterEnCines (val listener:OnItemClickListener):
    RecyclerView.Adapter<AdapterEnCines.Celda2Holder>(), Filterable{

    private var listaEnCines=ArrayList<ResultEnCine>()
    private var listaCopia = ArrayList<ResultEnCine>()

    interface  OnItemClickListener{
        fun OnItemClick(resultEnCine: ResultEnCine)
    }

    inner class Celda2Holder(val binding: CeldapopularesBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Celda2Holder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=CeldapopularesBinding.inflate(inflater,parent,false)
        return Celda2Holder(binding)
    }

    override fun onBindViewHolder(holder: Celda2Holder, position: Int) {
        val enCine: ResultEnCine =listaEnCines.get(position)
        holder.binding.nPeli.text=enCine.title
        holder.binding.flanzamiento.text=enCine.releaseDate
        holder.binding.mediaVoto.text=enCine.voteAverage.toString()
        holder.itemView.setOnClickListener {
            listener.OnItemClick(enCine)
        }
    }

    override fun getItemCount(): Int {
       return listaEnCines.size
    }

    fun actualizaLista2(lista:ArrayList<ResultEnCine>){
        listaEnCines.clear()
        listaEnCines.addAll(lista)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val busqueda = constraint.toString()

                if(busqueda.isEmpty()){
                    listaEnCines = listaCopia

                }else{
                    listaEnCines = listaCopia.filter {
                        it.title?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it.originalTitle?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it.releaseDate?.lowercase()?.contains(busqueda.lowercase()) ?: false
                    } as ArrayList<ResultEnCine>
                }
                val filterResult = FilterResults()
                filterResult.values = listaEnCines
                return filterResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listaEnCines = results?.values as ArrayList<ResultEnCine>
                notifyDataSetChanged()
            }

        }
    }
}