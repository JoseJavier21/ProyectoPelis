
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

            override fun publishResults(constraint: CharSequence?, results: FilterResu======>>>>>>> e18ade48dca65f9bf350f6ed01144



>>>>>>> Francis
