package com.example.proyectopelis.data.network

class Repositorio {

    private val retrofit= RetrofitHelper.getRetrofit()

    suspend fun getPelisEnCines(idioma: String,apikey:String,pagina: Int)=retrofit.getPelisEnCine(idioma, apikey ,pagina)

    suspend fun getPelisPopulares(idioma: String,apikey:String,pagina: Int)=retrofit.getPelisPopulares(idioma,apikey, pagina)

    suspend fun getRated(idioma: String,apikey: String, pagina: Int) = retrofit.getRated(idioma, apikey, pagina)

    suspend fun getComing(idioma: String,apikey: String, pagina: Int) = retrofit.getComing(idioma,apikey, pagina)

    suspend fun getPelisDetalles(idioma: String, idpeli: Int) = retrofit.damePelisDetalles(idioma, idpeli)

    suspend fun getPelisImagenes(idioma: String, idpeli: Int) = retrofit.damePelisImagenes(idioma, idpeli)

    suspend fun getPelisVideos(idioma: String, idpeli: Int) = retrofit.damePelisVideos(idioma, idpeli)

}