package com.example.proyectopelis.data.network

<<<<<<< HEAD

=======
>>>>>>> 4809d6214505be572d7e32dc00ee585e89dbcff2
import com.example.proyectopelis.data.network.TopRated.ResultRated
import com.example.proyectopelis.data.network.UpComing.ResultComing
import com.example.proyectopelis.data.network.Detalles.PelisDetalles
import com.example.proyectopelis.data.network.Imagenes.PelisImagenes
import com.example.proyectopelis.data.network.NowPlaying.PelisEnCine
import com.example.proyectopelis.data.network.Videos.PelisVideos
<<<<<<< HEAD
=======
import com.example.proyectopelis.data.network.Popular.PelisPopulares
>>>>>>> 4809d6214505be572d7e32dc00ee585e89dbcff2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

<<<<<<< HEAD

=======
>>>>>>> 4809d6214505be572d7e32dc00ee585e89dbcff2
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

<<<<<<< HEAD
    @Headers("Content-Type: application/json")//,"api-key: 5f7af1e971090ad23a762fcc923ac6ce")
=======
    @Headers("Content-Type: application/json")
>>>>>>> 4809d6214505be572d7e32dc00ee585e89dbcff2
    @GET("movie/{movie_id}")
    suspend fun damePelisDetalles(
        @Query("language") idioma : String,
        @Query("api_key") key : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisDetalles>

<<<<<<< HEAD
    @Headers("Content-Type: application/json")//,"api-key: 5f7af1e971090ad23a762fcc923ac6ce")
=======
    @Headers("Content-Type: application/json")
>>>>>>> 4809d6214505be572d7e32dc00ee585e89dbcff2
    @GET("movie/{movie_id}/images")
    suspend fun damePelisImagenes(
        @Query("language") idioma : String,
        @Query("api_key") key : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisImagenes>
<<<<<<< HEAD

    @Headers("Content-Type: application/json")//,"api-key: 5f7af1e971090ad23a762fcc923ac6ce")
    @GET("movie/{movie_id}/videos")
    suspend fun damePelisVideos(
        @Query("language") idioma : String,
        @Query("api_key") key : String,
        @Path("movie_id") idpeli: Int
    ) : Response<PelisVideos>

=======
>>>>>>> 4809d6214505be572d7e32dc00ee585e89dbcff2
}