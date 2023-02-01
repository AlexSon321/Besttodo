package com.example.besttodo.homeweather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besttodo.homeweather.data.WeatherRepository
import com.example.besttodo.homeweather.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class WeatherViewModel(): ViewModel() {
    private val repository = WeatherRepository()
    val weatherMain: MutableLiveData<Response<Weather>> = MutableLiveData()
    val weatherCity: MutableLiveData<Response<Weather>> = MutableLiveData()

    fun getWeather(){
        viewModelScope.launch(Dispatchers.IO) {
            viewModelScope.launch {
                weatherMain.value = repository.getWeather()
            }
        }
    }


    fun getCity(city: String){
        viewModelScope.launch(Dispatchers.IO) {
            viewModelScope.launch {
                weatherCity.value = repository.getCity(city)
            }
        }
    }



}