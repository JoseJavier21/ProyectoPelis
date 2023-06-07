package com.example.proyectopelis.data.network

import android.content.Context

class Repositorio(val context: Context) {

    private val retrofit= RetrofitHelper.getRetrofit()

    suspend fun getPelisEnCines(idioma: String,apikey:String,pagina: Int)=retrofit.getPelisEnCine(idioma, apikey ,pagina)

    suspend fun getPelisPopulares(idioma: String,apikey:String,pagina: Int)=retrofit.getPelisPopulares(idioma,apikey, pagina)

    suspend fun getRated(idioma: String,apikey: String, pagina: Int) = retrofit.getRated(idioma, apikey, pagina)

    suspend fun getComing(idioma: String,apikey: String, pagina: Int) = retrofit.getComing(idioma,apikey, pagina)

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    suspend fun getPelisDetalles(idioma: String, key: String, idpeli: Int) = retrofit.damePelisDetalles(idioma, key, idpeli)
=======
    suspend fun getPelisDetalles(idpeli: Int, idioma: String, key: String) = retrofit.damePelisDetalles(idpeli, idioma, key)
>>>>>>> Juan

    suspend fun getPelisImagenes(idpeli: Int, idioma: String, key: String) = retrofit.damePelisImagenes(idpeli, idioma, key)

    suspend fun getPelisVideos(idpeli: Int, idioma: String, key: String) = retrofit.damePelisVideos(idpeli, idioma, key)
=======
    suspend fun getPelisDetalles(idpeli: Int,idioma: String, key: String) = retrofit.damePelisDetalles(idpeli,idioma, key)

    suspend fun getPelisImagenes(idpeli: Int,idioma: String, key: String) = retrofit.damePelisImagenes(idpeli,idioma, key)

    suspend fun getPelisVideos(idpeli: Int,idioma: String, key: String) = retrofit.damePelisVideos(idpeli,idioma, key)
>>>>>>> 95e1437df85d04bb5292ff4079d96b887164abfa

}