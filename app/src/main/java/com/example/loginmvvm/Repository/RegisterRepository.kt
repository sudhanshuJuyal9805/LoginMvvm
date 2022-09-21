package com.example.loginmvvm.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.loginmvvm.DB.RegisterDatabaseDao
import com.example.loginmvvm.Model.RegisterEntity

class RegisterRepository(private val dao: RegisterDatabaseDao) {

    private var loginMutableLiveData=MutableLiveData<RegisterEntity>()
    private  val _loginMutableLiveData=MutableLiveData<RegisterEntity>()
    val getLoginLiveData:LiveData<RegisterEntity>
        get() = loginMutableLiveData

//        get() =loginMutableLiveData



    fun insert(user: RegisterEntity) {

        return dao.insert(user)
    }
   fun login(email:String,password:String):RegisterEntity
    {
      return  dao.login(email,password)
//        loginMutableLiveData.postValue(response.)
    }

}