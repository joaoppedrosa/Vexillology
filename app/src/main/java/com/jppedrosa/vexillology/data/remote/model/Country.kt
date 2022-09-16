package com.jppedrosa.vexillology.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 14/09/2022.
 */
data class Country(@SerializedName("name") val name: Name) {
    @SerializedName("tld")
    val tld: List<String> = emptyList()

    @SerializedName("independent")
    val independent: Boolean? = null

    @SerializedName("status")
    val status: String? = null

    @SerializedName("unMember")
    val unMember: Boolean? = null

    @SerializedName("capital")
    val capital: List<String> = emptyList()

    @SerializedName("altSpellings")
    val altSpellings: List<String> = emptyList()

    @SerializedName("region")
    val region: String? = null

    @SerializedName("subregion")
    val subregion: String? = null

    @SerializedName("latlng")
    val latlng: List<Double>? = null

    @SerializedName("landlocked")
    val landlocked: Boolean? = null

    @SerializedName("borders")
    val borders: List<String> = emptyList()

    @SerializedName("flag")
    val flag: String? = null

    @SerializedName("maps")
    val maps: Maps? = null

    @SerializedName("population")
    val population: Int? = null

    @SerializedName("fifa")
    val fifa: String? = null

    @SerializedName("timezones")
    val timezones: List<String> = emptyList()

    @SerializedName("continents")
    val continents: List<String> = emptyList()

    @SerializedName("flags")
    val flags: Flags? = null

    @SerializedName("coatOfArms")
    val coatOfArms: CoatOfArms? = null

    @SerializedName("startOfWeek")
    val startOfWeek: String? = null

    @SerializedName("capitalInfo")
    val capitalInfo: CapitalInfo? = null

    @SerializedName("postalCode")
    val postalCode: PostalCode? = null
}