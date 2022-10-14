package com.muradyan.tictactoe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.muradyan.tictactoe.databinding.ActivityMainBinding
import com.muradyan.tictactoe.fragment.HomeFragment
import com.muradyan.tictactoe.viewModel.MainActivityViewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds


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
        initAdMob()
        replaceFragment(HomeFragment())
    }

    fun replaceFragment(fragment: Fragment, backStack: String? = null) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(backStack).commit()
    }

    fun addFragment(fragment: Fragment, backStack: String? = null) {
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).addToBackStack(backStack).commit()
    }


    override fun onStart() {
        super.onStart()
        binding.adView.resume()
    }

    override fun onPause() {
        super.onPause()
        binding.adView.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.adView.destroy()
    }

    private fun initAdMob() {
        MobileAds.initialize(this) { }

        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
    }
}