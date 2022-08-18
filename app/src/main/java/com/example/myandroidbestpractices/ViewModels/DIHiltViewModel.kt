package com.example.myandroidbestpractices.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myandroidbestpractices.DI.Cryptocurrency
import com.example.myandroidbestpractices.DI.CryptocurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
 
// @HiltViewModel will make models to be
// created using Hilt's model factory
// @Inject annotation used to inject all
// dependencies to view model class
@HiltViewModel
class DIHiltViewModel @Inject constructor(
    private val cryptocurrencyRepository: CryptocurrencyRepository
) : ViewModel() {
    private val cryptocurrencyEmitter = MutableLiveData<List<Cryptocurrency>>()
    val cryptoCurrency: LiveData<List<Cryptocurrency>> = cryptocurrencyEmitter
    init {
        loadCryptocurrency()
    }
     
    // getting cryptocurrencies list using
    // repository and passing it into live data
    private fun loadCryptocurrency() {
        cryptocurrencyEmitter.value = cryptocurrencyRepository.getCryptoCurrency()
    }
}