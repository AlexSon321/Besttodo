package com.example.besttodo.todoscreen.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName="todoList")

@Parcelize
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nameTodo: String,
    val descTodo: String
): Parcelable
