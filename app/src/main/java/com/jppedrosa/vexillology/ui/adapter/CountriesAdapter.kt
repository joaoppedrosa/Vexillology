package com.jppedrosa.vexillology.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jppedrosa.vexillology.common.extensions.load
import com.jppedrosa.vexillology.databinding.RowItemCountryBinding
import com.jppedrosa.vexillology.data.remote.model.Country

class CountriesAdapter(var countries: ArrayList<Country>) :
    RecyclerView.Adapter<CountriesAdapter.CountryVH>() {

    /**
     * On create view holder
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryVH =
        CountryVH(RowItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    /**
     * On bind view holder
     *
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: CountryVH, position: Int) =
        holder.bind(this.countries[position])

    /**
     * Get item count
     *
     */
    override fun getItemCount() = this.countries.size

    /**
     * Add countries
     *
     * @param countriesList
     */
    @SuppressLint("NotifyDataSetChanged")
    fun addCountries(countriesList: List<Country>) {
        this.countries.clear()
        this.countries.addAll(countriesList)
        notifyDataSetChanged()
    }

    /**
     * Country view holder
     *
     * @property binding view binding
     * @constructor Create empty Country view holder instance
     */
    class CountryVH(private val binding: RowItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Bind
         *
         * @param country object
         */
        fun bind(country: Country) {
            this.binding.name.text = country.name.common
            this.binding.image.load(country.flags?.png)
        }
    }
}