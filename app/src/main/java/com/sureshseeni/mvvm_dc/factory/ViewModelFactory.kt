package com.sureshseeni.mvvm_dc.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sureshseeni.mvvm_dc.network.ApiServices
import com.sureshseeni.mvvm_dc.network.di.component.DaggerNetworkComponent
import com.sureshseeni.mvvm_dc.ui.activities.welcome.WelcomeActivityViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Inject

class ViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var retrofit: Retrofit

    lateinit var apiService: ApiServices

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //Network Data injection
        DaggerNetworkComponent.builder().build().inject(this)
        //initialize api service
        apiService= retrofit.create(ApiServices::class.java)

        if(modelClass.isAssignableFrom(WelcomeActivityViewModel::class.java)){
            return WelcomeActivityViewModel(Dispatchers.Main,apiService) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}