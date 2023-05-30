package com.example.proyectopelis.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import com.example.proyectopelis.databinding.CeldapopularesBinding


class AdapterPopulares (val listener: OnItemClickListener):
    RecyclerView.Adapter<AdapterPopulares.CeldaHolder>(), Filterable {

    private var listaPopulares=ArrayList<ResultPopulares>()
    private var listaCopia = ArrayList<ResultPopulares>()

    interface OnItemClickListener{
        fun OnItemClick(resultPopulares: ResultPopulares)
    }

    inner class  CeldaHolder(val binding: CeldapopularesBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=CeldapopularesBinding.inflate(inflater,parent,false)
        return CeldaHolder(binding)
    }

    override fun onBindViewHolder(holder: CeldaHolder, position: Int) {
        val populares: ResultPopulares=listaPopulares.get(position)
        holder.binding.nPeli.text=populares.title
        holder.binding.flanzamiento.text=populares.releaseDate
        holder.binding.mediaVoto.text=populares.voteAverage.toString()
        holder.itemView.setOnClickListener {
            listener.OnItemClick(populares)
        }
        //Glide.with(requireContext).load(populares.posterPath).into(binding.)
    }

    override fun getItemCount(): Int {
        return listaPopulares.size
    }

    fun actualizaLista(lista:ArrayList<ResultPopulares>){
        listaPopulares.clear()
        listaPopulares.addAll(lista)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val busqueda = constraint.toString()

                if(busqueda.isEmpty()){
                    listaPopulares = listaCopia

                }else{
                    listaPopulares = listaCopia.filter {
                        it.title?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it.originalTitle?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it.releaseDate?.lowercase()?.contains(busqueda.lowercase()) ?: false
                    } as ArrayList<ResultPopulares>
                }
                val filterResult = FilterResults()
                filterResult.values = listaPopulares
                return filterResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listaPopulares = results?.values as ArrayList<ResultPopulares>
                notifyDataSetChanged()
            }

        }
    }
}