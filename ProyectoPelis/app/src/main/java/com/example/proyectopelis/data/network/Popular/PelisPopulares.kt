package com.example.proyectopelis.data.network.Popular


import com.squareup.moshi.Json

data class PelisPopulares(
    @field:Json(name = "page")
    val page: Int?,
    @field:Json(name = "results")
    val resultPopulares: List<ResultPopulares?>?,
    @field:Json(name = "total_pages")
    val totalPages: Int?,
    @field:Json(name = "total_results")
    val totalResults: Int?
)