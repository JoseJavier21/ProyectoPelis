package com.example.proyectopelis.data.network

import android.content.Context

class Repositorio(val context: Context) {

    private val retrofit= RetrofitHelper.getRetrofit()

    suspend fun getPelisEnCines(idioma: String,apikey:String,pagina: Int)=retrofit.getPelisEnCine(idioma, apikey ,pagina)

    suspend fun getPelisPopulares(idioma: String,apikey:String,pagina: Int)=retrofit.getPelisPopulares(idioma,apikey, pagina)

    suspend fun getRated(idioma: String, pagina: Int) = retrofit.getRated(idioma, pagina)

    suspend fun getComing(idioma: String, pagina: Int) = retrofit.getComing(idioma, pagina)

    suspend fun getPelisDetalles(idpeli: Int, idioma: String, key: String) = retrofit.damePelisDetalles(idpeli, idioma, key)

    suspend fun getPelisImagenes(idpeli: Int, idioma: String, key: String) = retrofit.damePelisImagenes(idpeli, idioma, key)

<<<<<<< HEAD
    suspend fun getPelisDetalles(idpeli: Int,idioma: String, key: String) = retrofit.damePelisDetalles(idpeli,idioma, key)

    suspend fun getPelisImagenes(idpeli: Int,idioma: String, key: String) = retrofit.damePelisImagenes(idpeli,idioma, key)

    suspend fun getPelisVideos(idpeli: Int,idioma: String, key: String) = retrofit.damePelisVideos(idpeli,idioma, key)
=======
    suspend fun getPelisVideos(idpeli: Int, idioma: String, key: String) = retrofit.damePelisVideos(idpeli, idioma, key)

>>>>>>> Juan
}