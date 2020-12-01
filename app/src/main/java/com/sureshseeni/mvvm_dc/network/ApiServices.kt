package com.sureshseeni.mvvm_dc.network

import com.sureshseeni.mvvm_dc.network.model.RestCountries
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("rest/v2/all ")
    suspend fun getRestCountries(): Response<List<RestCountries.RestCountriesItem>>
}