package com.example.proyectopelis.data.network

class Repositorio {

    private val retrofit= RetrofitHelper.getRetrofit()

    suspend fun getPelisEnCines(idioma: String,pagina:Int) = retrofit.getPelisEnCine(idioma, pagina)

    suspend fun  getPelisPopulares(idioma: String,pagina: Int) =retrofit.getPelisPopulares(idioma, pagina)

    suspend fun getRated(idioma: String, api: String) = retrofit.getRated(idioma, api)

    suspend fun getComing(idioma: String, api: String) = retrofit.getComing(idioma, api)
}