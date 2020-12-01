package com.sureshseeni.mvvm_dc.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sureshseeni.mvvm_dc.R
import com.sureshseeni.mvvm_dc.databinding.RowCountryListingItemBinding
import com.sureshseeni.mvvm_dc.network.model.RestCountries

class CountriesListAdapter(
    val ctx: Context,
    private val list: List<RestCountries.RestCountriesItem>
) :
    RecyclerView.Adapter<CountriesListAdapter.WelcomeActivityActivityViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WelcomeActivityActivityViewHolder {
        return WelcomeActivityActivityViewHolder(
            DataBindingUtil.inflate<RowCountryListingItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.row_country_listing_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WelcomeActivityActivityViewHolder, position: Int) {
        holder.itemBinding.tvCountry.text = list[position].name

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class WelcomeActivityActivityViewHolder(itemView: RowCountryListingItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val itemBinding = itemView
    }


}