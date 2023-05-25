package com.example.proyectopelis.data.TopRated


import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Top_rated(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val resultRateds: List<ResultRated?>?,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
) : Parcelable