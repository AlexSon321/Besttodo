package com.example.besttodo.homeweather.data

import com.example.besttodo.homeweather.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("current.json?key=d83781fca1f64e29bc6211055232901&q=Lutsk,Ukraine&aqi=yes")
    suspend fun getWeather(): Response<Weather>

    @GET("current.json?key=d83781fca1f64e29bc6211055232901&&aqi=yes")
    suspend fun getCity(@Query("q") city: String): Response<Weather>

}