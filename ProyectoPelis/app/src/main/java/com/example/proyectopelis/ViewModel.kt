package com.example.proyectopelis

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.proyectopelis.data.Repositorio
import com.example.proyectopelis.data.models.Detalles.PelisDetalles
import com.example.proyectopelis.data.models.Imagenes.PelisImagenes
import com.example.proyectopelis.data.models.Videos.PelisVideos
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(): ViewModel() {

    private val repository = Repositorio()

    val pelisEnCine=MutableLiveData<List<ResultEnCine?>?>()
    val pelisPopulares=MutableLiveData<List<ResultPopulares?>?>()
    val liveDataPelisDetalles = MutableLiveData<PelisDetalles?>()
    val liveDataPelisImagenes = MutableLiveData<PelisImagenes?>()
    val liveDataPelisVideos = MutableLiveData<PelisVideos?>()


    fun getListaEnCines(){
        CoroutineScope(Dispatchers.IO).launch {
            val response=repository.getPelisEnCine()
            if(response.isSuccessful){
                val miRespuesta=response.body()
                pelisEnCine.postValue(miRespuesta)
            }
        }
    }

    fun getListaPopulares(){
        CoroutineScope(Dispatchers.IO).launch{
            val response=repository.getPelisPopulares()
            if (response.isSuccesful){
                val miRespuesta=response.body()
                pelisPopulares.postValue(miRespuesta)
            }
        }
    }



    fun getPelisDetalles(apikey: String, idioma: String, idpeli: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisDetalles(apikey, idioma, idpeli)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                liveDataPelisDetalles.postValue(miRespuesta)
            }
        }
    }

    fun getPelisImagenes(apikey: String, idioma: String, idpeli: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisImagenes(apikey, idioma, idpeli)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                liveDataPelisImagenes.postValue(miRespuesta)
            }
        }
    }

    fun getPelisVideos(apikey: String, idioma: String, idpeli: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisVideos(apikey, idioma, idpeli)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                liveDataPelisVideos.postValue(miRespuesta)
            }
        }
    }

    class MyViewModelFactory(private val context: Context): ViewModelProvider.Factory {
        override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }
}