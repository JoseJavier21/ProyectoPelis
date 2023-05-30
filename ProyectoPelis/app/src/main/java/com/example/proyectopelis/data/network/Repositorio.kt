package com.example.proyectopelis.data.network

class Repositorio {

    private val retrofit= RetrofitHelper.getRetrofit()

    //suspend fun getPelisEnCines(idioma: String,pagina: Int)=retrofit.getPelisEnCine(idioma, pagina)

    suspend fun getPelisPopulares(idioma: String,pagina: Int)=retrofit.getPelisPopulares(idioma, pagina)

    suspend fun getRated(idioma: String, pagina: Int) = retrofit.getRated(idioma, pagina)

    suspend fun getComing(idioma: String, pagina: Int) = retrofit.getComing(idioma, pagina)

//    suspend fun getPelisDetalles(idioma: String, idpeli: Int) = retrofit.damePelisDetalles(idioma, idpeli)
//
//    suspend fun getPelisImagenes(idioma: String, idpeli: Int) = retrofit.damePelisImagenes(idioma, idpeli)
//
//    suspend fun getPelisVideos(idioma: String, idpeli: Int) = retrofit.damePelisVideos(idioma, idpeli)
//
//    suspend fun getPelisDetalles(
//        idioma: String,
//        idpeli: Int
//    ) = retrofit.damePelisDetalles(idioma, idpeli)
//
//    suspend fun getPelisImagenes(
//        idioma: String,
//        idpeli: Int
//    ) = retrofit.damePelisImagenes(idioma, idpeli)
//
//    suspend fun getPelisVideos(
//        idioma: String,
//        idpeli: Int
//    ) = retrofit.damePelisVideos(idioma, idpeli)

}