package com.example.tictactoe.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tictactoe.screen.PlayFragmentLayout

class PlayFragment : Fragment() {
    private var screen: PlayFragmentLayout? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        screen = PlayFragmentLayout(requireContext())

        return screen
    }
}