package com.jppedrosa.vexillology.data.repository

import com.jppedrosa.vexillology.domain.VexillologyRepository
import com.jppedrosa.vexillology.data.remote.VexillologyApi
import com.jppedrosa.vexillology.data.remote.model.Country
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 16/09/2022.
 */
class VexillologyRepositoryImpl @Inject constructor(
    private val api: VexillologyApi
) : VexillologyRepository {

    override fun getCountries(): Single<List<Country>> {
        return this.api.getCountries()
    }
}