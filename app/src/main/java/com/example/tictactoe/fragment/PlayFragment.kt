package com.example.tictactoe.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tictactoe.R
import com.example.tictactoe.item.BoardButtonType
import com.example.tictactoe.screen.PlayFragmentLayout
import com.example.tictactoe.utils.removeFromSuperview
import com.example.tictactoe.viewModel.PlayViewModel

class PlayFragment : Fragment() {
    private lateinit var playViewModel: PlayViewModel
    private var screen: PlayFragmentLayout? = null
    var isClicked = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        screen = PlayFragmentLayout(requireContext())
        initBackgroundArrayPositions()
        return screen
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        playViewModel = ViewModelProvider(this)[PlayViewModel::class.java]
        playViewModel.refreshLiveData.observe(viewLifecycleOwner) {
            refresh()
        }

        screen?.refreshImageView?.setOnClickListener {
            playViewModel.refresh()
        }
    }

    private fun initBackgroundArrayPositions() {
        for (i in screen?.gameBoardView?.backgroundArray!!.indices) {
            for (j in screen?.gameBoardView?.backgroundArray!![i].indices) {
                val btn = screen?.gameBoardView?.backgroundArray!![i][j]
                btn.setOnClickListener {
                    btn.isEnabled = false
                    screen?.gameBoardView?.createBoardButtonByAnimation()?.apply {
                        screen?.gameBoardView?.foregroundArray?.get(i)?.add(this)
                        val params = layoutParams as FrameLayout.LayoutParams
                        screen?.gameBoardView?.setParamsByPosition(params, i, j)
                        bgColor = ContextCompat.getColor(context, R.color.board_button_color_2)
                        if (isClicked) {
                            type = BoardButtonType.X
                        } else {
                            type = BoardButtonType.O
                        }
                        isClicked = !isClicked
                        scaleAnimate()
                    }
                }
                val params = btn.layoutParams as FrameLayout.LayoutParams
                screen?.gameBoardView?.setParamsByPosition(params, i, j)
            }

        }
    }

    fun refresh() {
        isClicked = false
        for (i in screen?.gameBoardView?.foregroundArray!!.indices) {
            for (j in screen?.gameBoardView?.foregroundArray!![i].indices) {
                screen?.gameBoardView?.foregroundArray!![i][j]?.removeFromSuperview()
            }
            screen?.gameBoardView?.foregroundArray!![i].clear()
        }

        for (i in screen?.gameBoardView?.backgroundArray!!.indices) {
            for (j in screen?.gameBoardView?.backgroundArray!!.indices) {
                screen?.gameBoardView?.backgroundArray!![i][j].isEnabled = true
            }
        }
        screen?.requestLayout()
    }
}