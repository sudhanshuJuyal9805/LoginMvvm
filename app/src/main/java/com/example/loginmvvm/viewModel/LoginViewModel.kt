package com.example.loginmvvm.viewModel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginmvvm.Repository.RegisterRepository


class LoginViewModel(private val repository: RegisterRepository, application: Application) :
    AndroidViewModel(application) {
    init {

    }

//    val users = repository.users

    val inputEmail = MutableLiveData<String>()

    val inputPassword = MutableLiveData<String>()

    fun loginButton() {


    }

    fun signUP() {

    }


}
