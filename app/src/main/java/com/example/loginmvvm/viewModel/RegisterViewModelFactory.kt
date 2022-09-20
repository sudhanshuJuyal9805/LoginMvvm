package com.example.loginmvvm.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginmvvm.Repository.RegisterRepository

class RegisterViewModelFactory(private  val repository: RegisterRepository,
                               private val application: Application
) :ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegisterViewModel(repository,application) as T
    }

}