package com.example.myandroidbestpractices.DI

import com.example.myandroidbestpractices.DI.Cryptocurrency

interface CryptocurrencyRepository {
    fun getCryptoCurrency(): List<Cryptocurrency>

}