package com.example.proyectopelis.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.proyectopelis.data.Repositorio
import com.example.proyectopelis.data.network.Detalles.PelisDetalles
import com.example.proyectopelis.data.network.Imagenes.PelisImagenes
import com.example.proyectopelis.data.network.Videos.PelisVideos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(val context: Context): ViewModel() {

    private val repository = Repositorio(context)

    val liveDataPelisDetalles = MutableLiveData<PelisDetalles?>()
    val liveDataPelisImagenes = MutableLiveData<PelisImagenes?>()
    val liveDataPelisVideos = MutableLiveData<PelisVideos?>()

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