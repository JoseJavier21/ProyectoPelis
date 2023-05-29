package com.example.proyectopelis.data.network

import com.example.proyectopelis.data.TopRated.ResultRated
import com.example.proyectopelis.data.UpComing.ResultComing
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

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