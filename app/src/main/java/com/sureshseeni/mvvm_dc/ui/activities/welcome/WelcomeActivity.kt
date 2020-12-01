package com.sureshseeni.mvvm_dc.ui.activities.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sureshseeni.mvvm_dc.R
import com.sureshseeni.mvvm_dc.databinding.ActivityWelcomeBinding
import com.sureshseeni.mvvm_dc.factory.ViewModelFactory
import com.sureshseeni.mvvm_dc.ui.adapter.CountriesListAdapter

class WelcomeActivity : AppCompatActivity() {

    lateinit var welcomeBinding: ActivityWelcomeBinding
    lateinit var viewModel: WelcomeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View binding
        welcomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)
        //ViewModel initialization
        val viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(WelcomeActivityViewModel::class.java)
        welcomeBinding.welcomeViewModel=viewModel
        viewModel.getCountriesFromApi()

        viewModel.restCountries.observe(this, Observer {
            //Apply function just configure the recyclerview
            welcomeBinding.rvListCountries.apply {
               this.adapter = CountriesListAdapter(context, it)
            }

        })


    }
}