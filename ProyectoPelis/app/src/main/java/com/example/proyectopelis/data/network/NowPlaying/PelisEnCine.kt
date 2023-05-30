package com.example.proyectopelis.data.network.NowPlaying


import com.squareup.moshi.Json

data class PelisEnCine(
    @Json(name = "dates")
    val dates: Dates?,
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val resultEnCines: List<ResultEnCine?>?,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
)