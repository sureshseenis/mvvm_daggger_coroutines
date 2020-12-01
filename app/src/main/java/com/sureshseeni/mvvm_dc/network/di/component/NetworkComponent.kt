package com.sureshseeni.mvvm_dc.network.di.component

import com.sureshseeni.mvvm_dc.network.di.module.NetworkModule
import com.sureshseeni.mvvm_dc.factory.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
   fun inject(viewModelFactory: ViewModelFactory)
}