package com.example.proyectopelis.data.network

import com.example.proyectopelis.data.network.TopRated.ResultRated
import com.example.proyectopelis.data.network.UpComing.ResultComing
import com.example.proyectopelis.data.network.Detalles.PelisDetalles
import com.example.proyectopelis.data.network.Imagenes.PelisImagenes
import com.example.proyectopelis.data.network.NowPlaying.PelisEnCine
import com.example.proyectopelis.data.network.Videos.PelisVideos
import com.example.proyectopelis.data.network.Popular.PelisPopulares
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("movie/now_playing")
    suspend fun getPelisEnCine(
        @Query("language") idioma: String,
        @Query("api_key")apikey:String,
        @Query("page") pagina:Int
    ):Response<PelisEnCine>

    @Headers("Content-Type: application/json")
    @GET("movie/popular")
    suspend fun getPelisPopulares(
        @Query("language")idioma: String,
        @Query("api_key")apikey:String,
        @Query("page") pagina:Int
    ):Response<PelisPopulares>

    @Headers("Content-Type: application/json")
    @GET("movie/top_rated")
    suspend fun getRated(
        @Query("language")idioma: String,
        @Query("page")pagina:Int
    ): Response<ResultRated>

    @Headers("Content-Type: application/json")
    @GET("movie/upcoming")
    suspend fun getComing(
        @Query("language")idioma: String,
        @Query("page")pagina:Int
    ): Response<ResultComing>

    @Headers("Content-Type: application/json")
    @GET("movie/{movie_id}")
    suspend fun damePelisDetalles(
        @Query("language") idioma : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisDetalles>

    @Headers("Content-Type: application/json")
    @GET("movie/{movie_id}/images")
    suspend fun damePelisImagenes(
        @Query("language") idioma : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisImagenes>
}