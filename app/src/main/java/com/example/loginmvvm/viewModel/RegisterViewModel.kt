package com.example.loginmvvm.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.loginmvvm.Model.RegisterEntity
import com.example.loginmvvm.Repository.RegisterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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


    fun submitButton() {
        val firstName=inputFirstName.value
        val lastName=inputLastName.value
        val userName=inputEmail.value
        val password=inputPassword.value
        insert(RegisterEntity(0, firstName!!, lastName!!, userName!!, password!!))
        inputFirstName.value = null
        inputLastName.value = null
        inputEmail.value = null
        inputPassword.value = null

    }







    private fun insert(user: RegisterEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(user)

        }
    }





}
