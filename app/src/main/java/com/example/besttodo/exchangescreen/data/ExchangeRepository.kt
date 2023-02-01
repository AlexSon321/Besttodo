package com.example.besttodo.exchangescreen.data

import com.example.besttodo.exchangescreen.model.Exchange
import retrofit2.Response

class ExchangeRepository {

    suspend fun getExchange(): Response<Exchange>{
        return RetrofitInstance.api.getExchange()
    }

}