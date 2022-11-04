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
import com.muradyan.tictactoe.item.BoardButton
import com.muradyan.tictactoe.item.BoardButtonType
import com.muradyan.tictactoe.screen.PlayFragmentScreen
import com.muradyan.tictactoe.ui.GameBoardPoint
import com.muradyan.tictactoe.ui.LineDrawType
import com.muradyan.tictactoe.utils.removeFromSuperview
import com.muradyan.tictactoe.viewModel.PlayViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

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
        playViewModel.winTypeLiveData.observe(viewLifecycleOwner) { winType ->
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
                    addForegroundButton(btn, i, j)
                }
                val params = btn.layoutParams as FrameLayout.LayoutParams
                screen?.gameBoardView?.setParamsByPosition(params, i, j)
            }
        }
    }

    fun addRandomPosition() {
        CoroutineScope(Dispatchers.Main).launch {
            if (!isClicked) {
                return@launch
            }
            if (screen?.gameBoardView?.notSelectedItemList!!.size > 0) {
                val randomPosition = Random.nextInt(screen?.gameBoardView?.notSelectedItemList!!.size)
                if (randomPosition < 0) {
                    return@launch
                }
                val position = screen?.gameBoardView?.notSelectedItemList!![randomPosition]
                val i = position.i
                val j = position.j
                addForegroundButton(screen?.gameBoardView?.backgroundArray!![i][j], i, j)
            }
        }
    }

    fun addButton_X() {
        addRandomPosition()
    }

    fun addButton_O() {
        addRandomPosition()
    }


    fun addForegroundButton(button: BoardButton, i: Int, j: Int) {
        button.isEnabled = false
        screen?.gameBoardView?.createBoardButtonByAnimation()?.apply {
            screen?.gameBoardView?.foregroundArray!![i][j] = this
            val params = layoutParams as FrameLayout.LayoutParams
            screen?.gameBoardView?.setParamsByPosition(params, i, j)
            screen?.gameBoardView?.notSelectedItemList?.remove(GameBoardPoint(i, j))
            bgColor = ContextCompat.getColor(context, R.color.board_button_color_2)
            type = if (isClicked) {
                BoardButtonType.X
            } else {
                BoardButtonType.O
            }
            isClicked = !isClicked
            scaleAnimate(::addRandomPosition)
            playViewModel.win2(screen?.gameBoardView?.foregroundArray!!)
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
        screen?.gameBoardView?.notSelectedItemList?.clear()
        screen?.gameBoardView?.notSelectedItemList = screen?.gameBoardView?.createNotSelectedItemList()!!

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