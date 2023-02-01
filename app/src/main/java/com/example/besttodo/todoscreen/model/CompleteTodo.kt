package com.example.besttodo.todoscreen.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "completeTodo")

data class CompleteTodo(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nameTodo: String,
    val descTodo: String
)