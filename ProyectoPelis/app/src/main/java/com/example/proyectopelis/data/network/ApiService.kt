package com.example.proyectopelis.data.network

//<<<<<<< HEAD
import com.example.proyectopelis.data.TopRated.ResultRated
import com.example.proyectopelis.data.UpComing.ResultComing
/*import retrofit2.Response
import retrofit2.http.GET
=======*/
import com.example.proyectopelis.data.network.Detalles.PelisDetalles
import com.example.proyectopelis.data.network.Imagenes.PelisImagenes
import com.example.proyectopelis.data.network.Videos.PelisVideos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
//>>>>>>> Juan
import retrofit2.http.Query

interface ApiService {

    @Headers("Content-Type: application/json,api-key:5f7af1e971090ad23a762fcc923ac6ce")
    @GET("movie/now_playing")
    suspend fun getPelisEnCine(
        @Query("language")idioma: String,
        @Query("page")pagina:String
    )

    @Headers("Content-Type: application/json,api-key:5f7af1e971090ad23a762fcc923ac6ce")
    @GET("movie/popular")
    suspend fun getPelisPopulares(
        @Query("language")idioma: String,
        @Query("page")pagina:String
    )

    @Headers("Content-Type: application/json,api-key:5f7af1e971090ad23a762fcc923ac6ce")
    @GET("movie/top_rated")
    suspend fun getRated(
        @Query("language")idioma: String,
        @Query("page")pagina:String
    ): Response<ResultRated>

    @Headers("Content-Type: application/json,api-key:5f7af1e971090ad23a762fcc923ac6ce")
    @GET("movie/upcoming")
    suspend fun getComing(
        @Query("language")idioma: String,
        @Query("page")pagina:String
    ): Response<ResultComing>

    @Headers("Content-Type: application/json,api-key:5f7af1e971090ad23a762fcc923ac6ce")
    @GET("movie/{movie_id}")
    suspend fun damePelisDetalles(
        @Query("language") idioma : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisDetalles>

    @Headers("Content-Type: application/json,api-key:5f7af1e971090ad23a762fcc923ac6ce")
    @GET("movie/{movie_id}/images")
    suspend fun damePelisImagenes(
        @Query("language") idioma : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisImagenes>

    @Headers("Content-Type: application/json,api-key:5f7af1e971090ad23a762fcc923ac6ce")
    @GET("movie/{movie_id}/videos")
    suspend fun damePelisVideos(
        @Query("language") idioma : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisVideos>

}