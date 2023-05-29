package com.example.proyectopelis.data.network.Popular


import com.squareup.moshi.Json

data class PelisPopulares(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val results: List<Result?>?,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
)