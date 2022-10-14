package com.example.tictactoe.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.tictactoe.MainActivity
import com.example.tictactoe.screen.HomeFragmentScreen

class HomeFragment : Fragment() {
    companion object {
        const val TAG = "HomeFragment"
    }
    var screen: HomeFragmentScreen? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        screen = HomeFragmentScreen(requireContext())
        screen?.playWithYourSelfButton?.setOnClickListener {
            (activity as? MainActivity?)?.addFragment(PlayFragment(), TAG)
        }
        return screen
    }


}