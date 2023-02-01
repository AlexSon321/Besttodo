package com.example.besttodo.todoscreen.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.besttodo.todoscreen.model.CompleteTodo

@Dao
interface CompleteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addComplete(completeTodo: CompleteTodo)
    @Query("SELECT * from completeTodo ORDER BY id ASC")
    fun allComplete(): LiveData<List<CompleteTodo>>
    @Query("DELETE from completeTodo")
    suspend fun deleteAll()


}