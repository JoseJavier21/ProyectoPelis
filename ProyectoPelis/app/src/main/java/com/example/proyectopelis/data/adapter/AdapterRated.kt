package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectopelis.R
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.TopRated.ResultRated
import com.example.proyectopelis.data.network.TopRated.Top_rated
import com.example.proyectopelis.databinding.CeldaratedBinding
import com.example.proyectopelis.ui.TopRated

class AdapterRated(val listener:OnItemClickListener): RecyclerView.Adapter<AdapterRated.CeldaRated>(), Filterable {

    private var listaOriginal = ArrayList<ResultRated?>()
    private var copiaLista = ArrayList<ResultRated?>()

    interface OnItemClickListener{
        fun OnItemClick(resultRated: ResultRated)
    }

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

        val rated: ResultRated? = listaOriginal.get(position)
        val context = holder.itemView.context
        holder.binding.nombrePeli.text = rated?.title
        holder.binding.puntuacion.text = rated?.voteAverage.toString()
        holder.binding.idioma.text = rated?.originalLanguage
        Glide.with(context).load("https://image.tmdb.org/t/p/original/${rated?.posterPath}").into(holder.binding.imgpeli)
        holder.itemView.setOnClickListener {
            if (rated!=null){
                listener.OnItemClick(rated)
            }
        }
    }

    fun updateRated(lista: List<ResultRated?>){
        listaOriginal.clear()
        listaOriginal.addAll(lista)
        copiaLista.clear()
        copiaLista.addAll(lista)
        notifyDataSetChanged()

    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val busqueda = constraint.toString()

                if(busqueda.isEmpty()){
                    listaOriginal = copiaLista
                }else{
                    listaOriginal = copiaLista.filter {
                        it?.title?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it?.originalTitle?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it?.releaseDate?.lowercase()?.contains(busqueda.lowercase()) ?: false
                    } as ArrayList<ResultRated?>
                }
                val filterResult = FilterResults()
                filterResult.values = listaOriginal
                return filterResult
            }
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listaOriginal = results?.values as ArrayList<ResultRated?>
                notifyDataSetChanged()
            }
        }
    }
}