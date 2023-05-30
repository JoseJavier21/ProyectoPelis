package com.example.proyectopelis.data.network

//<<<<<<< HEAD
import com.example.proyectopelis.data.TopRated.ResultRated
import com.example.proyectopelis.data.UpComing.ResultComing
/*import retrofit2.Response
import retrofit2.http.GET
=======*/
import com.example.proyectopelis.data.models.Detalles.PelisDetalles
import com.example.proyectopelis.data.models.Imagenes.PelisImagenes
import com.example.proyectopelis.data.models.Videos.PelisVideos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
//>>>>>>> Juan
import retrofit2.http.Query

interface ApiService {

//<<<<<<< HEAD
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
//=======
    @Headers("Content-Type: application/json")
    @GET("movie/{movie_id}")
    suspend fun damePelisDetalles(
        @Query("api_key") apikey : String,
        @Query("language") idioma : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisDetalles>

    @Headers("Content-Type: application/json")
    @GET("movie/{movie_id}/images")
    suspend fun damePelisImagenes(
        @Query("api_key") apikey : String,
        @Query("language") idioma : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisImagenes>

    @Headers("Content-Type: application/json")
    @GET("movie/{movie_id}/videos")
    suspend fun damePelisVideos(
        @Query("api_key") apikey : String,
        @Query("language") idioma : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisVideos>
//>>>>>>> Juan
}