package com.example.proyectopelis.data

import android.content.Context
import com.example.proyectopelis.data.network.RetrofitHelper

class Repositorio(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPelisDetalles(
        apikey: String,
        idioma: String,
        idpeli: Int
    ) = retrofit.damePelisDetalles(idioma, idpeli)

    suspend fun getPelisImagenes(
        apikey: String,
        idioma: String,
        idpeli: Int
    ) = retrofit.damePelisImagenes(idioma, idpeli)

    suspend fun getPelisVideos(
        apikey: String,
        idioma: String,
        idpeli: Int
    ) = retrofit.damePelisVideos(idioma, idpeli)
}