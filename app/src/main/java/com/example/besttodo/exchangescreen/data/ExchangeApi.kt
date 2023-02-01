package com.example.besttodo.exchangescreen.data

import com.example.besttodo.exchangescreen.model.Exchange
import retrofit2.Response
import retrofit2.http.GET

interface ExchangeApi {

    @GET("p24api/pubinfo?json&exchange&coursid=5")
    suspend fun getExchange(): Response<Exchange>

}