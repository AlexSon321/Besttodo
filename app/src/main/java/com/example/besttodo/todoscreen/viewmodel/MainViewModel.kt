package com.example.besttodo.todoscreen.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.besttodo.todoscreen.database.MainDatabase
import com.example.besttodo.todoscreen.database.MainRepository
import com.example.besttodo.todoscreen.model.TodoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    val todoList: LiveData<List<TodoItem>>
    private var repository: MainRepository

    init{
        val mainDao = MainDatabase.createDatabase(application).getDao()
        repository = MainRepository(mainDao)
        todoList = repository.allTodo
    }

    fun addTodo(todoItem: TodoItem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTodo(todoItem)
        }
    }

    fun updateTodo(todoItem: TodoItem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTodo(todoItem)
        }
    }

    fun deleteTodo(todoItem: TodoItem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTodo(todoItem)
        }
    }

}