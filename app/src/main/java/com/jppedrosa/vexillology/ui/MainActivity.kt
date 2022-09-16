package com.jppedrosa.vexillology.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jppedrosa.vexillology.databinding.ActivityMainBinding
import com.jppedrosa.vexillology.di.factories.ViewModelFactory
import com.jppedrosa.vexillology.ui.adapter.CountriesAdapter
import com.jppedrosa.vexillology.ui.base.BaseActivity
import com.jppedrosa.vexillology.ui.vm.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private val countriesAdapter = CountriesAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        val view = this.binding.root
        setContentView(view)

        this.viewModel = ViewModelProvider(this, this.viewModelFactory)[MainViewModel::class.java]

        this.viewModel.refresh()

        this.binding.countriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        this.binding.swipeToRefresh.setOnRefreshListener {
            this.binding.swipeToRefresh.isRefreshing = false
            this.viewModel.refresh()
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.countries.observe(this) { countries ->
            countries?.let {
                this.binding.countriesRecyclerView.visibility = View.VISIBLE
                this.binding.apiErrorMessage.visibility = View.GONE
                this.countriesAdapter.addCountries(it)
            }
        }

        this.viewModel.countryLoadError.observe(this) { errorMessage ->
            errorMessage?.let {
                this.binding.apiErrorMessage.text = it
                this.binding.apiErrorMessage.visibility = View.VISIBLE
                this.binding.countriesRecyclerView.visibility = View.GONE
                this.binding.loading.visibility = View.GONE
            }
        }

        this.viewModel.loading.observe(this) { isLoading ->
            isLoading?.let {
                this.binding.loading.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    this.binding.countriesRecyclerView.visibility = View.GONE
                    this.binding.apiErrorMessage.visibility = View.GONE
                }
            }
        }
    }
}