package com.jppedrosa.vexillology.data.remote.model

import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("common") val common: String,
    @SerializedName("official") val official: String
)