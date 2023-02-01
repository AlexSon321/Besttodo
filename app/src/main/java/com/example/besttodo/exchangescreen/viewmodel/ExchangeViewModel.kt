package com.example.besttodo.exchangescreen.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besttodo.exchangescreen.data.ExchangeRepository
import com.example.besttodo.exchangescreen.model.Exchange
import kotlinx.coroutines.launch
import retrofit2.Response

class ExchangeViewModel: ViewModel() {
    private var repository = ExchangeRepository()
    var exchangeList: MutableLiveData<Response<Exchange>> = MutableLiveData()

    fun getExchange() {
        viewModelScope.launch {

            exchangeList.value = repository.getExchange()
        }
    }



}