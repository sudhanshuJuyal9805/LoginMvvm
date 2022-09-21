package com.example.loginmvvm.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.loginmvvm.Model.RegisterEntity
import com.example.loginmvvm.Repository.RegisterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: RegisterRepository, application: Application) :
    AndroidViewModel(application){

    init {
        Log.i("MYTAG", "init")
    }



    val inputFirstName = MutableLiveData<String>()

    val inputLastName = MutableLiveData<String>()

    val inputEmail = MutableLiveData<String>()

    val inputPassword = MutableLiveData<String>()

    private val _navigateto = MutableLiveData<Boolean>()

    private val _errToast=MutableLiveData<Boolean>()

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val navigateto: LiveData<Boolean>
        get() = _navigateto
   val errorToast:LiveData<Boolean>
   get() = _errToast

    fun submitButton() {
        uiScope.launch {
            val firstName=inputFirstName.value
            val lastName=inputLastName.value
            val email=inputEmail.value
            val password=inputPassword.value
            if(firstName!!.isEmpty()||lastName!!.isEmpty()||email!!.isEmpty()||password!!.isEmpty())
            {
                _errorToast.value=true
            }
            insert(RegisterEntity(0, firstName, lastName!!, email!!, password!!))
            inputFirstName.value = null
            inputLastName.value = null
            inputEmail.value = null
            inputPassword.value = null
            _navigateto.value = true
        }


    }
    fun doneNavigating() {
        _navigateto.value = false
        Log.i("MYTAG", "Done navigating ")
    }







    private fun insert(user: RegisterEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(user)

        }
    }





}
