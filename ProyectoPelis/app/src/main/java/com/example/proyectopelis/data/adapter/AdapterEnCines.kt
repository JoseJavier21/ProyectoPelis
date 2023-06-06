package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.databinding.CeldafrancisBinding


class AdapterEnCines (private val listener: OnItemClickListener) :
    RecyclerView.Adapter<AdapterEnCines.Celda2Holder>(), Filterable{

    private var listaEnCines=ArrayList<ResultEnCine?>()
    private var listaCopia = ArrayList<ResultEnCine?>()

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
        val pathPoster=enCine?.posterPath
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/original/${pathPoster}").into(holder.binding.imagenPeli)
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
        listaCopia.clear()
        listaEnCines.addAll(lista)
        listaCopia.addAll(lista)
        notifyDataSetChanged()
    }
    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val busqueda = constraint.toString()

                if(busqueda.isEmpty()){
                    listaEnCines=listaCopia

                }else{
                    listaEnCines = listaCopia.filter {
                        it?.title?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it?.originalTitle?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it?.releaseDate?.lowercase()?.contains(busqueda.lowercase()) ?: false
                    } as ArrayList<ResultEnCine?>
                }
                val filterResult = FilterResults()
                filterResult.values = listaEnCines
                return filterResult
            }
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listaEnCines = results?.values as ArrayList<ResultEnCine?>
                notifyDataSetChanged()
            }
        }
    }
}
