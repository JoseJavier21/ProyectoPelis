package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectopelis.R
import com.example.proyectopelis.data.network.Detalles.Genre
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.TopRated.ResultRated
import com.example.proyectopelis.data.network.UpComing.ResultComing
import com.example.proyectopelis.data.network.UpComing.UpComing
import com.example.proyectopelis.databinding.CeldacomingBinding

class AdapterUpComing(val listener:OnItemClickListener): RecyclerView.Adapter<AdapterUpComing.CeldaComing>(), Filterable {

    private var listaOriginal = ArrayList<ResultComing?>()
    private var copiaLista = ArrayList<ResultComing?>()
    private val listageneros = ArrayList<Genre>()

    interface  OnItemClickListener{
        fun OnItemClick(resultComing: ResultComing)
    }

    inner class CeldaComing(val binding: CeldacomingBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaComing {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CeldacomingBinding.inflate(inflater, parent, false)
        return CeldaComing(binding)
    }

    override fun getItemCount(): Int {
        return listaOriginal.size
    }

    override fun onBindViewHolder(holder: CeldaComing, position: Int) {

        val comig: ResultComing? = listaOriginal.get(position)
        val context = holder.itemView.context

        holder.binding.titleComing.text = comig?.title
        holder.binding.idiomaComing.text = comig?.originalLanguage
        //holder.binding.genderComing.text = comig?.genreIds.toString()
        holder.binding.popuComing.text = comig?.popularity.toString() + " personas"
        Glide.with(context).load("https://image.tmdb.org/t/p/original/${comig?.posterPath}").into(holder.binding.imgComig)

        holder.itemView.setOnClickListener {
           if (comig != null){
               listener.OnItemClick(comig)
           }
        }

    }

    fun updataComing(lista: List<ResultComing?>){
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
                    } as ArrayList<ResultComing?>
                }
                val filterResult = FilterResults()
                filterResult.values = listaOriginal
                return filterResult
            }
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listaOriginal = results?.values as ArrayList<ResultComing?>
                notifyDataSetChanged()
            }
        }
    }
}

