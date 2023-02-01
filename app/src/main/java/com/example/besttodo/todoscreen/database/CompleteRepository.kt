package com.example.besttodo.todoscreen.database

import androidx.lifecycle.LiveData
import com.example.besttodo.todoscreen.model.CompleteTodo

class CompleteRepository(var completeDao: CompleteDao){

    val allComplete: LiveData<List<CompleteTodo>> = completeDao.allComplete()

    suspend fun addComplete(completeTodo: CompleteTodo){
        completeDao.addComplete(completeTodo)
    }

    suspend fun deleteAll(){
        completeDao.deleteAll()
    }

}