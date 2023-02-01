package com.example.besttodo.todoscreen.database

import androidx.lifecycle.LiveData
import com.example.besttodo.todoscreen.model.TodoItem

class MainRepository(var mainDao: MainDao) {
    val allTodo: LiveData<List<TodoItem>> = mainDao.allTodo()


    suspend fun updateTodo(todoItem: TodoItem){
        mainDao.updateTodo(todoItem)
    }

    suspend fun addTodo(todoItem: TodoItem){
        mainDao.addTodo(todoItem)
    }

    suspend fun deleteTodo(todoItem: TodoItem){
        mainDao.deleteTodo(todoItem)
    }

}