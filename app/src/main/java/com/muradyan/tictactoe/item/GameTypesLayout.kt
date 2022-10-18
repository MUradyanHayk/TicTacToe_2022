package com.muradyan.tictactoe.item

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.muradyan.tictactoe.R
import com.muradyan.tictactoe.utils.dp

class GameTypesLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {
    private var item1: GameTypeItem? = null
    private var item2: GameTypeItem? = null
    private var item3: GameTypeItem? = null

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent_color))
        this.orientation = HORIZONTAL
        this.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        createItem1()
        createItem2()
        createItem3()
    }

    private fun createItem1() {
        item1 = GameTypeItem(context)
        val params = LayoutParams(110.dp, 190.dp)
        item1?.setPadding(16.dp, 16.dp, 16.dp, 16.dp)
        item1?.layoutParams = params
        item1?.text = "sdkfsdffmsdflgdfgk"
        addView(item1)
    }

    private fun createItem2() {
        item2 = GameTypeItem(context)
        val params = LayoutParams(110.dp, 190.dp)
        item2?.setPadding(16.dp, 16.dp, 16.dp, 16.dp)
        item2?.layoutParams = params
        item2?.text = "sdkfsdffmsdflgdfgk"
        addView(item2)
    }

    private fun createItem3() {
        item3 = GameTypeItem(context)
        val params = LayoutParams(110.dp, 190.dp)
        item3?.setPadding(16.dp, 16.dp, 16.dp, 16.dp)
        item3?.layoutParams = params
        item3?.text = "sdkfsdffmsdflgdfgk"
        addView(item3)
    }
}