package com.example.proyectopelis.data.network.NowPlaying


import com.squareup.moshi.Json

data class PelisEnCine(
    @field:Json(name = "dates")
    val dates: Dates?,
    @field:Json(name = "page")
    val page: Int?,
    @field:Json(name = "results")
    val resultEnCines: List<ResultEnCine?>?,
    @field:Json(name = "total_pages")
    val totalPages: Int?,
    @field:Json(name = "total_results")
    val totalResults: Int?
)