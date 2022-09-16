package com.jppedrosa.vexillology.data.remote

import com.jppedrosa.vexillology.data.remote.model.Country
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 14/09/2022.
 */
interface VexillologyApi {

    @GET("v3.1/all")
    fun getCountries(): Single<List<Country>>
}