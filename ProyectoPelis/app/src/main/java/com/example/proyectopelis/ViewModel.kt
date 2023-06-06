package com.example.proyectopelis

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.proyectopelis.data.network.NowPlaying.PelisEnCine
import com.example.proyectopelis.data.network.Repositorio
import com.example.proyectopelis.data.network.Detalles.PelisDetalles
import com.example.proyectopelis.data.network.Imagenes.PelisImagenes
import com.example.proyectopelis.data.network.Videos.PelisVideos
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.Popular.PelisPopulares
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(val context: Context) : ViewModel() {

    private val repository = Repositorio()
    val pelisEnCine=MutableLiveData<List<ResultEnCine?>?>()
    val pelisPopulares=MutableLiveData<List<ResultPopulares?>?>()
    val pelisCine=MutableLiveData<PelisEnCine>()
    val pelisPopu=MutableLiveData<PelisPopulares>()
    val peliSelecionada1= MutableLiveData<ResultEnCine?>()
    val peliSelecionada2= MutableLiveData<ResultPopulares?>()
    val liveDataPelisDetalles = MutableLiveData<PelisDetalles?>()
    val liveDataPelisImagenes = MutableLiveData<PelisImagenes?>()
    val liveDataPelisVideos = MutableLiveData<PelisVideos?>()


    fun getListaEnCines(idioma: String, apikey: String, pagina: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisEnCines(idioma, apikey, pagina)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                pelisEnCine.postValue(miRespuesta?.resultEnCines)
                pelisCine.postValue(miRespuesta!!)
            }
        }
    }

    fun getListaPopulares(idioma: String, apikey: String, pagina: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisPopulares(idioma, apikey, pagina)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                pelisPopulares.postValue(miRespuesta?.resultPopulares)
                pelisPopu.postValue(miRespuesta!!)
            }
        }
    }

    fun getPelisDetalles(idioma: String, key: String, idpeli: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisDetalles(idioma, key, idpeli)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                liveDataPelisDetalles.postValue(miRespuesta)
            }
        }
    }

    fun getPelisImagenes(idioma: String, key: String, idpeli: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisImagenes(idioma, key, idpeli)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                liveDataPelisImagenes.postValue(miRespuesta)
            }
        }
    }


    fun getPelisVideos(idioma: String, key: String, idpeli: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPelisVideos(idioma, key, idpeli)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                liveDataPelisVideos.postValue(miRespuesta)
            }
        }

    fun selectPeli(resultEnCine: ResultEnCine){
        peliSelecionada1.value=resultEnCine
    }
    fun selectPeli2(resultPopulares: ResultPopulares){
        peliSelecionada2.value=resultPopulares
    }

        class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return modelClass.getConstructor(Context::class.java).newInstance(context)
            }
        }
    }
}