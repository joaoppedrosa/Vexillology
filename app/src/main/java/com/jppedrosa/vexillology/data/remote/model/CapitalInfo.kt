package com.jppedrosa.vexillology.data.remote.model

import com.google.gson.annotations.SerializedName

data class CapitalInfo(
    @SerializedName("latlng") val latlng: List<Double>
)