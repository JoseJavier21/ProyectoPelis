package com.example.proyectopelis.data.network


import com.example.proyectopelis.data.network.Detalles.PelisDetalles
import com.example.proyectopelis.data.network.Imagenes.PelisImagenes
import com.example.proyectopelis.data.network.NowPlaying.PelisEnCine
import com.example.proyectopelis.data.network.Videos.PelisVideos
<<<<<<< HEAD
=======
import com.example.proyectopelis.data.network.Popular.PelisPopulares
import com.example.proyectopelis.data.network.TopRated.Top_rated
import com.example.proyectopelis.data.network.UpComing.UpComing
>>>>>>> main
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

<<<<<<< HEAD

=======
>>>>>>> main
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
        @Query("api_key")apikey: String,
        @Query("page")pagina:Int
    ): Response<Top_rated>

    @Headers("Content-Type: application/json")
    @GET("movie/upcoming")
    suspend fun getComing(
        @Query("language")idioma: String,
        @Query("api_key")apikey: String,
        @Query("page")pagina:Int
    ): Response<UpComing>

<<<<<<< HEAD
    @Headers("Content-Type: application/json")//,"api-key: 5f7af1e971090ad23a762fcc923ac6ce")
=======
    @Headers("Content-Type: application/json")
>>>>>>> main
    @GET("movie/{movie_id}")
    suspend fun damePelisDetalles(
        @Path("movie_id") idpeli: Int,
        @Query("language") idioma : String,
        @Query("api_key") key : String
    ) : Response<PelisDetalles>

<<<<<<< HEAD
    @Headers("Content-Type: application/json")//,"api-key: 5f7af1e971090ad23a762fcc923ac6ce")
=======

    @Headers("Content-Type: application/json","api-key: 5f7af1e971090ad23a762fcc923ac6ce")
>>>>>>> main
    @GET("movie/{movie_id}/images")
    suspend fun damePelisImagenes(
        @Path("movie_id") idpeli: Int,
        @Query("language") idioma : String,
        @Query("api_key") key : String
    ) : Response<PelisImagenes>

    @Headers("Content-Type: application/json")//,"api-key: 5f7af1e971090ad23a762fcc923ac6ce")
    @GET("movie/{movie_id}/videos")
    suspend fun damePelisVideos(
        @Path("movie_id") idpeli: Int,
        @Query("language") idioma : String,
        @Query("api_key") key : String
    ) : Response<PelisVideos>


}