package com.example.tictactoe.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
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
                        if (win()) {
                            setEnabledButton(false)
                            Toast.makeText(context, "win", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                val params = btn.layoutParams as FrameLayout.LayoutParams
                screen?.gameBoardView?.setParamsByPosition(params, i, j)
            }

        }
    }

    fun win(): Boolean {
        val arr = screen?.gameBoardView?.foregroundArray!!
// ===============================================================
        var isWin = false
        for (i in arr.indices) {
            val type = arr[i][0]?.type
            for (j in arr.indices) {
                isWin = true
                if (arr[i][j]?.type != type || arr[i][j] == null) {
                    isWin = false
                    break
                }
            }
            if (isWin) {
                return true
            }
        }

        // ===============================================================
        for (i in arr.indices) {
            val type = arr[0][i]?.type
            for (j in arr.indices) {
                isWin = true
                if (arr[j][i]?.type != type || arr[j][i] == null) {
                    isWin = false
                    break
                }
            }
            if (isWin) {
                return true
            }
        }

        // ===============================================================
        for (i in arr.indices) {
            val type = arr[0][0]?.type
            isWin = true
            if (arr[i][i]?.type != type || arr[i][i] == null) {
                isWin = false
                break
            }
        }

        if (isWin) {
            return true
        }

        // ===============================================================
        for (i in arr.indices) {
            val type = arr[0][arr.size - 1]?.type
            isWin = true
            if (arr[i][arr.size - 1 - i]?.type != type || arr[i][arr.size - 1 - i] == null) {
                isWin = false
                break
            }
        }

        if (isWin) {
            return true
        }
        // ===============================================================


        return isWin
    }

    fun refresh() {
        isClicked = false
        val fgArr = screen?.gameBoardView?.foregroundArray!!
        val bgArr = screen?.gameBoardView?.backgroundArray!!
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
                bgArr[i][j]?.isEnabled = isEnabled
            }
        }
    }


}