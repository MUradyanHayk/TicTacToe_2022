package com.muradyan.tictactoe.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.muradyan.tictactoe.R
import com.muradyan.tictactoe.item.BoardButtonType
import com.muradyan.tictactoe.screen.PlayFragmentScreen
import com.muradyan.tictactoe.ui.LineDrawType
import com.muradyan.tictactoe.utils.removeFromSuperview
import com.muradyan.tictactoe.viewModel.PlayViewModel

class PlayFragment : Fragment() {
    companion object {
        const val TAG = "PlayFragment"
    }
    private lateinit var playViewModel: PlayViewModel
    private var screen: PlayFragmentScreen? = null
    var isClicked = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        screen = PlayFragmentScreen(requireContext())
        initBackgroundArrayPositions()
        return screen
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        playViewModel = ViewModelProvider(this)[PlayViewModel::class.java]
        playViewModel.refreshLiveData.observe(viewLifecycleOwner) {
            refresh()
        }
        playViewModel.winTypeLiveData.observe(viewLifecycleOwner) {winType->
            screen?.gameBoardView?.drawType = winType
            if (winType != LineDrawType.NONE) {
                setEnabledButton(false)
//                Toast.makeText(context, "win", Toast.LENGTH_SHORT).show()
            }
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
                    it.isEnabled = false
                    screen?.gameBoardView?.createBoardButtonByAnimation()?.apply {
                        screen?.gameBoardView?.foregroundArray!![i][j] = this
                        val params = layoutParams as FrameLayout.LayoutParams
                        screen?.gameBoardView?.setParamsByPosition(params, i, j)
                        bgColor = ContextCompat.getColor(context, R.color.board_button_color_2)
                        type = if (isClicked) {
                            BoardButtonType.X
                        } else {
                            BoardButtonType.O
                        }
                        isClicked = !isClicked
                        scaleAnimate()
                        playViewModel.win2(screen?.gameBoardView?.foregroundArray!!)
                    }
                }
                val params = btn.layoutParams as FrameLayout.LayoutParams
                screen?.gameBoardView?.setParamsByPosition(params, i, j)
            }
        }
    }

    fun refresh() {
        isClicked = false
        screen?.gameBoardView?.drawType = LineDrawType.NONE
        val fgArr = screen?.gameBoardView?.foregroundArray!!
        for (i in fgArr.indices) {
            for (j in fgArr[i].indices) {
                fgArr[i][j]?.removeFromSuperview()
                fgArr[i][j] = null
            }
        }

        setEnabledButton(true)

        screen?.requestLayout()
    }

    fun setEnabledButton(isEnabled: Boolean) {
        val bgArr = screen?.gameBoardView?.backgroundArray!!
        for (i in bgArr.indices) {
            for (j in bgArr.indices) {
                bgArr[i][j].isEnabled = isEnabled
            }
        }
    }
}