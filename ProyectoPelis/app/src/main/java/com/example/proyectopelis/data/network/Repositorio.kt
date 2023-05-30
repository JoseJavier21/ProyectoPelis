package com.example.proyectopelis.data.network

class Repositorio {

    private val retrofit= RetrofitHelper.getRetrofit()

<<<<<<< HEAD
    suspend fun getPelisEnCines(idioma: String,pagina:Int) = retrofit.getPelisEnCine(idioma, pagina)

    suspend fun  getPelisPopulares(idioma: String,pagina: Int) =retrofit.getPelisPopulares(idioma, pagina)

    suspend fun getRated(idioma: String, api: String) = retrofit.getRated(idioma, api)
=======
    suspend fun getPelisEnCines(idioma: String,pagina: Int)=retrofit.getPelisEnCine(idioma, pagina)
>>>>>>> pre-main

    suspend fun getPelisPopulares(idioma: String,pagina: Int)=retrofit.getPelisPopulares(idioma, pagina)

    suspend fun getRated(idioma: String, pagina: Int) = retrofit.getRated(idioma, pagina)

    suspend fun getComing(idioma: String, pagina: Int) = retrofit.getComing(idioma, pagina)
}