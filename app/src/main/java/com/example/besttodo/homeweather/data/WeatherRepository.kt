package com.example.besttodo.homeweather.data

import com.example.besttodo.homeweather.model.*
import retrofit2.Response

class WeatherRepository {


    suspend fun getWeather(): Response<Weather>{
        return RetrofitWeather.api.getWeather()
    }


    suspend fun getCity(city: String): Response<Weather>{
        return RetrofitWeather.api.getCity(city)
    }

}