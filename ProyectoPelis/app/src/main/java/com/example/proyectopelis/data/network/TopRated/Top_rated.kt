package com.example.proyectopelis.data.network.TopRated


import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Top_rated(
    @field:Json(name = "page")
    val page: Int?,
    @field:Json(name = "results")
    val resultRateds: List<ResultRated?>?,
    @field:Json(name = "total_pages")
    val totalPages: Int?,
    @field:Json(name = "total_results")
    val totalResults: Int?
) : Parcelable