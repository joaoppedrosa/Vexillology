package com.jppedrosa.vexillology.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jppedrosa.vexillology.data.remote.model.Country
import com.jppedrosa.vexillology.domain.VexillologyRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 14/09/2022.
 */
class MainViewModel @Inject constructor(
    private val repository: VexillologyRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()

    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        this.loading.value = true
        this.disposable.add(
            this.repository.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(value: List<Country>?) {
                        countries.value = value
                        countryLoadError.value = null
                        loading.value = false
                    }

                    override fun onError(e: Throwable?) {
                        countryLoadError.value = e?.message ?: "Unknown error"
                        loading.value = false
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        this.disposable.clear()
    }
}