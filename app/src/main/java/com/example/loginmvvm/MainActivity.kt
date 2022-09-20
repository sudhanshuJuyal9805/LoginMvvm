package com.example.loginmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
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
    }
}