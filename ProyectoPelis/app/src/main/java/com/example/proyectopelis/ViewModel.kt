package com.example.proyectopelis

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.proyectopelis.data.network.Detalles.PelisDetalles
import com.example.proyectopelis.data.network.Imagenes.PelisImagenes
import com.example.proyectopelis.data.network.Videos.PelisVideos
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import com.example.proyectopelis.data.network.Repositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(val context: Context) : ViewModel() {

    private val repository = Repositorio(context)

    val pelisEnCine=MutableLiveData<List<ResultEnCine?>?>()
    val pelisPopulares=MutableLiveData<List<ResultPopulares?>?>()
    val peliSelecionada= MutableLiveData<ResultEnCine>()
    val liveDataPelisDetalles = MutableLiveData<PelisDetalles?>()
    val liveDataPelisImagenes = MutableLiveData<PelisImagenes?>()
    val liveDataPelisVideos = MutableLiveData<PelisVideos?>()


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

    fun getPelisDetalles(idpeli: Int, idioma: String, key: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisDetalles(idpeli, idioma, key)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                liveDataPelisDetalles.postValue(miRespuesta)
            }
        }
    }

    fun getPelisImagenes(idpeli: Int, idioma: String, key: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisImagenes(idpeli, idioma, key)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                liveDataPelisImagenes.postValue(miRespuesta)
            }
        }
    }

    fun getPelisVideos(idpeli: Int, idioma: String, key: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisVideos(idpeli, idioma, key)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                liveDataPelisVideos.postValue(miRespuesta)
            }
        }
    }

    class MyViewModelFactory(private val context: Context): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }
}