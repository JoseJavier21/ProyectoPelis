package com.example.proyectopelis.data.network.UpComing


import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class UpComing(
    @field:Json(name = "dates")
    val dates: Dates?,
    @field:Json(name = "page")
    val page: Int?,
    @field:Json(name = "results")
    val resultComings: List<ResultComing?>?,
    @field:Json(name = "total_pages")
    val totalPages: Int?,
    @field:Json(name = "total_results")
    val totalResults: Int?
) : Parcelable