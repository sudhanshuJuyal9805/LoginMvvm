package com.example.loginmvvm.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.loginmvvm.Model.RegisterEntity

@Dao
interface RegisterDatabaseDao
{
    @Insert
    fun insert(register: RegisterEntity)

}