package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectopelis.R
import com.example.proyectopelis.data.network.Detalles.Genre
import com.example.proyectopelis.data.network.UpComing.ResultComing
import com.example.proyectopelis.data.network.UpComing.UpComing
import com.example.proyectopelis.databinding.CeldacomingBinding

class AdapterUpComing: RecyclerView.Adapter<AdapterUpComing.CeldaComing>() {

    private var listaOriginal = ArrayList<ResultComing?>()
    private val copiaLista = ArrayList<ResultComing?>()
    private val listageneros = ArrayList<Genre>()

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
            holder.itemView.findNavController().navigate(R.id.action_upComing_to_fragmentPelisDetalles) //nagevagion de la celda hacia la pantalla de detalle
        }

    }

    fun updataComing(lista: List<ResultComing?>){
        listaOriginal.clear()
        listaOriginal.addAll(lista)
        copiaLista.clear()
        copiaLista.addAll(lista)
        notifyDataSetChanged()
    }

    fun filtro(): Filter{
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val busqueda = p0.toString()

                if (p0.isNullOrEmpty()){
                    listaOriginal = copiaLista
                }else{
                    listaOriginal = copiaLista.filter {
                        it?.title?.lowercase()?.contains(p0) ?: false ||
                                it?.originalTitle?.lowercase()?.contains(p0) ?: false

                    } as ArrayList<ResultComing?>
                }
                val filtrado = FilterResults()
                filtrado.values = listaOriginal
                return filtrado
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                listaOriginal = p1?.values as ArrayList<ResultComing?>
                notifyDataSetChanged()
            }

        }
    }
}

