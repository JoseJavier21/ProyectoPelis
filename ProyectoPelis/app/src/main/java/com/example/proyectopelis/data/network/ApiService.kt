package com.example.proyectopelis.data.network

import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import com.example.proyectopelis.data.network.TopRated.ResultRated
import com.example.proyectopelis.data.network.UpComing.ResultComing
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    suspend fun getPelisEnCine(
        @Query("language") idioma: String,
        @Query("pages") pagina:Int
    ):Response<ResultEnCine>

    @GET("movie/popular")
    suspend fun getPelisPopulares(
        @Query("language") idioma: String,
        @Query("pages") pagina:Int
    ):Response<ResultPopulares>

    @GET("movie/top_rated")
    suspend fun getRated(
        @Query("language")idioma: String,
        @Query("api_key")api: String
    ): Response<ResultRated>

    @GET("movie/upcoming")
    suspend fun getComing(
        @Query("language")idioma: String,
        @Query("api_key")api: String
    ): Response<ResultComing>
}