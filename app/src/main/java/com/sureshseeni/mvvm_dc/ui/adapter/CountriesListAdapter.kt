package com.sureshseeni.mvvm_dc.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sureshseeni.mvvm_dc.R
import com.sureshseeni.mvvm_dc.network.model.RestCountries
import kotlinx.android.synthetic.main.row_country_listing_item.view.*


class CountriesListAdapter(val ctx: Activity, private val list: List<RestCountries.RestCountriesItem>) :
    RecyclerView.Adapter<CountriesListAdapter.WelcomeActivityActivityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WelcomeActivityActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_country_listing_item, null)
        return WelcomeActivityActivityViewHolder(view)
    }

    override fun onBindViewHolder(holder: WelcomeActivityActivityViewHolder, position: Int) {
        holder.itemView.tv_country.text = list[position].name



    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class WelcomeActivityActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}