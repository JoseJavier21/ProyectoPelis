package com.example.proyectopelis.data.UpComing


import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class UpComing(
    @Json(name = "dates")
    val dates: Dates?,
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val results: List<Result?>?,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
) : Parcelable