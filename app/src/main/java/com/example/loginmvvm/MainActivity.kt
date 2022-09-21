package com.example.loginmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.loginmvvm.DB.RegisterDatabase
import com.example.loginmvvm.Repository.RegisterRepository
import com.example.loginmvvm.viewModel.LoginViewModel
import com.example.loginmvvm.viewModel.LoginViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: LoginViewModel
    private lateinit var binding: com.example.loginmvvm.databinding.ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = RegisterDatabase.getInstance(application).registerDatabaseDao

        val repository= RegisterRepository(dao)
        mainActivityViewModel= ViewModelProvider(this,LoginViewModelFactory(repository,application))[LoginViewModel::class.java]
        binding.myLoginViewModel=mainActivityViewModel
        binding.lifecycleOwner=this
        mainActivityViewModel.navigateto.observe(this, Observer { hasFinished->
            if (hasFinished == true){
                Log.i("MYTAG","insidi observe")
                displayUsersList()
                mainActivityViewModel.doneNavigating()
            }
        })
        mainActivityViewModel.navigatetoLogin.observe(this, Observer { hasFinished->
            if (hasFinished == true){
                Log.i("MYTAG","insidi observe")
                toRegister()
                mainActivityViewModel.doneNavigating()
            }
        })
    }

    private fun toRegister() {
        val intent = Intent(this,HomePage::class.java)
        startActivity(intent)
        TODO("Not yet implemented")
    }

    private fun displayUsersList() {
        val intent = Intent(this,HomePage::class.java)
        startActivity(intent)
    }
}