package com.sureshseeni.mvvm_dc.ui.activities.welcome

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sureshseeni.mvvm_dc.network.ApiServices
import com.sureshseeni.mvvm_dc.network.model.RestCountries
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.launch
import java.lang.Exception

class WelcomeActivityViewModel(
   private val dispatcher: MainCoroutineDispatcher,
   private val apiService: ApiServices
) : ViewModel() {

   var restCountries = MutableLiveData<List<RestCountries.RestCountriesItem>>()

    //Data get from api
    fun getCountriesFromApi() {
        //use coroutines
        viewModelScope.launch(dispatcher) {
            try {
                val responseCountries = apiService.getRestCountries()
                if (responseCountries.isSuccessful) {
                    restCountries.value = responseCountries.body()
                }

            } catch (e: Exception) {
                Log.d("Error", "Api error" + e.message)
            }

        }

    }


}