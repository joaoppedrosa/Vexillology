package com.jppedrosa.vexillology

import com.jppedrosa.vexillology.data.remote.model.Country
import com.jppedrosa.vexillology.data.remote.model.Name
import com.jppedrosa.vexillology.domain.VexillologyRepository
import com.jppedrosa.vexillology.ui.vm.MainViewModel
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 16/09/2022.
 */
class MainViewModelTest : BaseViewModelTest() {

    @Mock
    lateinit var repository: VexillologyRepository

    @InjectMocks
    lateinit var mainViewModel: MainViewModel

    @Test
    fun getCountriesSuccess() {
        val name = Name("CountryNameCommon", "CountryNameOfficial")
        val country = Country(name)
        val countriesList: List<Country> = arrayListOf(country)
        val response = Single.just(countriesList)
        Mockito.`when`(this.repository.getCountries()).thenReturn(response)
        this.mainViewModel.refresh()
        assertEquals(1, this.mainViewModel.countries.value?.size)
        assertEquals(null, this.mainViewModel.countryLoadError.value)
        assertEquals(false, this.mainViewModel.loading.value)
    }

    @Test
    fun getCountriesFail() {
        val response = Single.error<List<Country>>(Throwable())
        Mockito.`when`(this.repository.getCountries()).thenReturn(response)
        this.mainViewModel.refresh()
        assertNotEquals(null, this.mainViewModel.countryLoadError.value)
        assertEquals(false, this.mainViewModel.loading.value)
    }
}