package com.example.proyectopelis

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.proyectopelis.data.network.Repositorio
import com.example.proyectopelis.data.network.Detalles.PelisDetalles
import com.example.proyectopelis.data.network.Imagenes.PelisImagenes
import com.example.proyectopelis.data.network.NowPlaying.PelisEnCine
import com.example.proyectopelis.data.network.Videos.PelisVideos
import com.example.proyectopelis.data.network.NowPlaying.ResultEnCine
import com.example.proyectopelis.data.network.Popular.PelisPopulares
import com.example.proyectopelis.data.network.Popular.ResultPopulares
import com.example.proyectopelis.data.network.TopRated.ResultRated
import com.example.proyectopelis.data.network.TopRated.Top_rated
import com.example.proyectopelis.data.network.UpComing.ResultComing
import com.example.proyectopelis.data.network.UpComing.UpComing
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(): ViewModel() {

    private val repository = Repositorio()
    val pelisEnCine=MutableLiveData<List<ResultEnCine?>?>()
    val pelisPopulares=MutableLiveData<List<ResultPopulares?>?>()
    val pelisCine=MutableLiveData<PelisEnCine>()
    val pelisPopu=MutableLiveData<PelisPopulares>()
    val peliSelecionada1= MutableLiveData<ResultEnCine?>()
    val peliSelecionada2= MutableLiveData<ResultPopulares?>()
    val peliSelecionada3= MutableLiveData<ResultRated?>()
    val peliSelecionada4= MutableLiveData<ResultComing?>()
    val liveDataPelisDetalles = MutableLiveData<PelisDetalles?>()
    val liveDataPelisImagenes = MutableLiveData<PelisImagenes?>()
    val liveDataPelisVideos = MutableLiveData<PelisVideos?>()
    val LivePeliRated=MutableLiveData<List<ResultRated?>?>()
    val Rated=MutableLiveData<Top_rated?>()
    val Coming=MutableLiveData<UpComing?>()
    val livePeliComing=MutableLiveData<List<ResultComing?>?>()



    fun getListaEnCines(idioma: String,apikey: String,pagina:Int){
        CoroutineScope(Dispatchers.IO).launch {
            val response=repository.getPelisEnCines(idioma,apikey,pagina)
            if(response.isSuccessful){
                val miRespuesta=response.body()
                pelisEnCine.postValue(miRespuesta?.resultEnCines)
                pelisCine.postValue(miRespuesta!!)
            }
        }
    }

    fun getListaPopulares(idioma: String,apikey: String,pagina:Int){
        CoroutineScope(Dispatchers.IO).launch{
            val response=repository.getPelisPopulares(idioma,apikey,pagina)
            if (response.isSuccessful){
                val miRespuesta=response.body()
                pelisPopulares.postValue(miRespuesta?.resultPopulares)
                pelisPopu.postValue(miRespuesta!!)
            }
        }
    }

    fun getListaComing(idioma: String, apikey: String, pagina: Int){

        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getComing(idioma,apikey,pagina)
            if(response.isSuccessful){
                val respuesta = response.body()
                livePeliComing.postValue(respuesta?.resultComings)
                Coming.postValue(respuesta!!)
            }
        }
    }

    fun getListaRated(idioma: String, apikey: String, pagina: Int){

        CoroutineScope(Dispatchers.IO).launch{
            val response = repository.getRated(idioma, apikey, pagina)
            if (response.isSuccessful){
                val respuesta = response.body()
                LivePeliRated.postValue(respuesta?.resultRateds)
                Rated.postValue(respuesta!!)
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

    fun selectPeli(resultEnCine: ResultEnCine){
        peliSelecionada1.value=resultEnCine
    }
    fun selectPeli2(resultPopulares: ResultPopulares){
        peliSelecionada2.value=resultPopulares
    }
    fun selectPeli3(resultRated: ResultRated){
        peliSelecionada3.value=resultRated
    }
    fun selectPeli4(resultComing: ResultComing){
        peliSelecionada4.value=resultComing
    }

    class MyViewModelFactory(private val context: Context): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }
}