package com.example.tictactoe.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tictactoe.screen.PlayFragmentLayout
import com.example.tictactoe.viewModel.PlayViewModel

class PlayFragment : Fragment() {
    private lateinit var playViewModel: PlayViewModel
    private var screen: PlayFragmentLayout? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        screen = PlayFragmentLayout(requireContext())

        return screen
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        playViewModel = ViewModelProvider(this)[PlayViewModel::class.java]
        playViewModel.refreshLiveData.observe(viewLifecycleOwner){
            screen?.refresh()
        }

        screen?.refreshImageView?.setOnClickListener {
            playViewModel.refresh()
        }
    }
}