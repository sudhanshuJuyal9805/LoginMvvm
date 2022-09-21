package com.example.loginmvvm.viewModel


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginmvvm.Model.RegisterEntity
import com.example.loginmvvm.Repository.RegisterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class LoginViewModel(private val repository: RegisterRepository, application: Application) :
    AndroidViewModel(application) {




    val userResponseLiveData: LiveData<RegisterEntity>
        get() = repository.getLoginLiveData
    private val _navigateto = MutableLiveData<Boolean>()
    private val _navigatetoRegister = MutableLiveData<Boolean>()

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val navigateto: LiveData<Boolean>
        get() = _navigateto
    val navigatetoLogin: LiveData<Boolean>
        get() = _navigatetoRegister

    init {

    }

//    val users = repository.users

    val inputEmail = MutableLiveData<String>()

    val inputPassword = MutableLiveData<String>()

    fun loginButton() {
        uiScope.launch {
            val email=inputEmail.value
            val password=inputPassword.value

            val response= repository.login(email!!,password!!)
            if(response.email.equals(email)&&response.passwrd.equals(password))
            {
                    _navigateto.value=true
            }
        }

    }

    fun signUP() {
        _navigatetoRegister.value=true

    }
    fun doneNavigating() {
        _navigateto.value = false
        _navigatetoRegister.value=false


        Log.i("MYTAG", "Done navigating ")
    }

}
