package com.example.proyectopelis.data.models.Imagenes

data class PelisImagenes(
    val backdrops: List<Backdrop>,
    val id: Int,
    val logos: List<Logo>,
    val posters: List<Poster>
)