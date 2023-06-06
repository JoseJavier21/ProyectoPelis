package com.example.proyectopelis.data.network.UpComing


import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Dates(
    @field:Json(name = "maximum")
    val maximum: String?,
    @field:Json(name = "minimum")
    val minimum: String?
) : Parcelable