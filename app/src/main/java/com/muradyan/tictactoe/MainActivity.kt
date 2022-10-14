package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.tictactoe.databinding.ActivityMainBinding
import com.example.tictactoe.fragment.HomeFragment
import com.example.tictactoe.fragment.PlayFragment
import com.example.tictactoe.viewModel.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var mainViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        replaceFragment(HomeFragment())
    }

    fun replaceFragment(fragment: Fragment, backStack: String? = null) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(backStack).commit()
    }

    fun addFragment(fragment: Fragment, backStack: String? = null) {
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).addToBackStack(backStack).commit()
    }
}