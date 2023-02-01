package com.example.besttodo.todoscreen.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.besttodo.todoscreen.model.CompleteTodo
import com.example.besttodo.todoscreen.model.TodoItem

@Database(entities = [TodoItem::class, CompleteTodo::class], version = 2, exportSchema = false)
abstract class MainDatabase: RoomDatabase() {
    abstract fun getDao(): MainDao
    abstract fun completeDao(): CompleteDao

    companion object {
        fun createDatabase(context: Context): MainDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDatabase::class.java,
                "MainDatabase"
            ).fallbackToDestructiveMigration().build()
        }
    }
}