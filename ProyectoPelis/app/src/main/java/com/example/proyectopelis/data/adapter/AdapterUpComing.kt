package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectopelis.R
import com.example.proyectopelis.data.network.UpComing.ResultComing
import com.example.proyectopelis.databinding.CeldacomingBinding
import com.example.proyectopelis.databinding.CeldaratedBinding
import com.example.proyectopelis.databinding.FragmentUpComingBinding

class AdapterUpComing: RecyclerView.Adapter<AdapterUpComing.CeldaComing>() {

    private val listaOriginal = ArrayList<ResultComing>()
    private val copiaLista = ArrayList<ResultComing>()

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

        val comig: ResultComing = copiaLista.get(position)
        val context = holder.itemView.context

        holder.binding.titleComing.text = comig.title
        holder.binding.puntuComing.text = comig.voteAverage.toString()
        holder.binding.idiomaComing.text = comig.originalLanguage
        //holder.binding.genderComing.text revisar para terminar de ponerlo
        holder.binding.popuComing.text = comig.popularity.toString()
        //Glide.with(context).load(comig.posterPath).placeholder(R.drawable.ic_launcher_background).into(R.id.imgComig)

        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(R.id.action_upComing_to_fragmentPelisDetalles) //nagevagion de la celda hacia la pantalla de detalle
        }

    }

    fun updataRated(lista: List<ResultComing>){
        listaOriginal.clear()
        listaOriginal.addAll(lista)
        copiaLista.clear()
        copiaLista.addAll(lista)
        notifyDataSetChanged()
    }


}