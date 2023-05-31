package com.example.proyectopelis

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.proyectopelis.data.network.Detalles.PelisDetalles
import com.example.proyectopelis.data.network.Imagenes.PelisImagenes
import com.example.proyectopelis.data.network.NowPlaying.PelisEnCine
import com.example.proyectopelis.data.network.Videos.PelisVideos
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import com.example.proyectopelis.data.network.Repositorio
import com.example.proyectopelis.data.network.TopRated.ResultRated
import com.example.proyectopelis.data.network.TopRated.Top_rated
import com.example.proyectopelis.data.network.UpComing.ResultComing
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(): ViewModel() {

    private val repository = Repositorio()

    val pelisEnCine =MutableLiveData<List<ResultEnCine?>?>()
    val pelisPopulares =MutableLiveData<List<ResultPopulares?>?>()
    val peliSelecionada = MutableLiveData<ResultEnCine?>()
    val liveDataPelisDetalles = MutableLiveData<PelisDetalles?>()
    val liveDataPelisImagenes = MutableLiveData<PelisImagenes?>()
    val liveDataPelisVideos = MutableLiveData<PelisVideos?>()
    val liveDataTopRated = MutableLiveData<List<ResultRated>?>()
    val liveDataUpComing = MutableLiveData<List<ResultComing?>?>()


    fun getListaEnCines(idioma: String,apikey: String,pagina:Int){
        CoroutineScope(Dispatchers.IO).launch {
            val response=repository.getPelisEnCines(idioma,apikey,pagina)
            if(response.isSuccessful){
                val miRespuesta=response.body()
                pelisEnCine.postValue(miRespuesta?.resultEnCines)
            }
        }
    }

    fun getListaPopulares(idioma: String,apikey: String,pagina:Int){
        CoroutineScope(Dispatchers.IO).launch{
            val response=repository.getPelisPopulares(idioma,apikey,pagina)
            if (response.isSuccessful){
                val miRespuesta=response.body()
                pelisPopulares.postValue(miRespuesta?.resultPopulares)
            }
        }
    }

    fun getListaRated(idioma: String, apikey: String, pagina: Int){

        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getRated(idioma,pagina)
            if(response.isSuccessful){
                val respuesta = response.body()
                liveDataTopRated.postValue(respuesta)
            }
        }
    }

    fun getListaComing(idioma: String, apikey: String, pagina: Int){

        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getComing(idioma,pagina)
            if (response.isSuccessful){
                val respuesta = response.body()
                //liveDataUpComing.postValue(respuesta)
            }
        }
    }

//    fun getPelisDetalles(idioma: String, idpeli: Int) {
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = repository.getPelisDetalles(idioma, idpeli)
//            if (response.isSuccessful) {
//                val miRespuesta = response.body()
//                liveDataPelisDetalles.postValue(miRespuesta)
//            }
//        }
//    }
//
//    fun getPelisImagenes(idioma: String, idpeli: Int) {
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = repository.getPelisImagenes(idioma, idpeli)
//            if (response.isSuccessful) {
//                val miRespuesta = response.body()
//                liveDataPelisImagenes.postValue(miRespuesta)
//            }
//        }
//    }
//
//    fun getPelisVideos(idioma: String, idpeli: Int) {
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = repository.getPelisVideos(idioma, idpeli)
//            if (response.isSuccessful) {
//                val miRespuesta = response.body()
//                liveDataPelisVideos.postValue(miRespuesta)
//            }
//        }
//    }

    fun selectPeli(resultEnCine: ResultEnCine){
        peliSelecionada.value=resultEnCine
    }

    class MyViewModelFactory(private val context: Context): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }
}