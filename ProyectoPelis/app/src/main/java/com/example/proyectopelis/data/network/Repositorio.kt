package com.example.proyectopelis.data.network

class Repositorio {

    private val retrofit= RetrofitHelper.getRetrofit()

    suspend fun getRated(idioma: String, api: String) = retrofit.getRated(idioma, api)

    suspend fun getComing(idioma: String, api: String) = retrofit.getComing(idioma, api)
}