package com.jppedrosa.vexillology.domain

import com.jppedrosa.vexillology.data.remote.model.Country
import io.reactivex.Single

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 16/09/2022.
 */
interface VexillologyRepository {
    fun getCountries(): Single<List<Country>>
}