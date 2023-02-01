package com.example.besttodo.todoscreen.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.besttodo.todoscreen.database.CompleteRepository
import com.example.besttodo.todoscreen.database.MainDatabase
import com.example.besttodo.todoscreen.model.CompleteTodo
import kotlinx.coroutines.launch

class CompleteViewModel(application: Application): AndroidViewModel(application) {

    var completeList: LiveData<List<CompleteTodo>>
    private val repository: CompleteRepository

    init{
        val completeDao = MainDatabase.createDatabase(application).completeDao()
        repository = CompleteRepository(completeDao)
        completeList = repository.allComplete
    }


    fun addComplete(completeTodo: CompleteTodo){
        viewModelScope.launch {
            repository.addComplete(completeTodo)
        }
    }

    fun deleteAll(){
        viewModelScope.launch {
            repository.deleteAll()
        }
    }




}