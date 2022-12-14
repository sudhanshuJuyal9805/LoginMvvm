package com.example.loginmvvm.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.loginmvvm.DB.RegisterDatabase
import com.example.loginmvvm.MainActivity
import com.example.loginmvvm.R
import com.example.loginmvvm.Repository.RegisterRepository
import com.example.loginmvvm.viewModel.RegisterViewModel
import com.example.loginmvvm.databinding.ActivityRegisterBinding
import com.example.loginmvvm.viewModel.RegisterViewModelFactory

class Register : AppCompatActivity() {
    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var binding:ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        val dao = RegisterDatabase.getInstance(application).registerDatabaseDao

        val repository=RegisterRepository(dao)
        registerViewModel= ViewModelProvider(this,RegisterViewModelFactory(repository,application))[RegisterViewModel::class.java]
        binding.myViewModel=registerViewModel
        binding.lifecycleOwner=this
        registerViewModel.navigateto.observe(this, Observer { hasFinished->
            if (hasFinished == true){
                Log.i("MYTAG","insidi observe")
                displayUsersList()
                registerViewModel.doneNavigating()
            }
        })
    }

    private fun displayUsersList() {

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}