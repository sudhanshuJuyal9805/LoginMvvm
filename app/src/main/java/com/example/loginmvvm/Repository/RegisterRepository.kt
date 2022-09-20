package com.example.loginmvvm.Repository

import com.example.loginmvvm.DB.RegisterDatabaseDao
import com.example.loginmvvm.Model.RegisterEntity

class RegisterRepository(private val dao: RegisterDatabaseDao) {



    fun insert(user: RegisterEntity) {

        return dao.insert(user)
    }

}