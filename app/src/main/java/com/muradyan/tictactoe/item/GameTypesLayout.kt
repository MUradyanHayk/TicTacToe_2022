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

    private var items = mutableListOf<GameTypeItem?>()

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent_color))
        this.orientation = HORIZONTAL
        this.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        createItem1()
        createItem2()
        createItem3()
        clipChildren = false
        clipToOutline = false
        clipToPadding = false
    }

    private fun createItem1() {
        item1 = GameTypeItem(context)
        val params = LayoutParams(100.dp, 134.dp)
        item1?.setPadding(16.dp, 16.dp, 16.dp, 16.dp)
        item1?.layoutParams = params
        item1?.text = "Player 1"
        item1?.setImageResource(R.drawable.ic_person_alone_svgrepo_com)
        items.add(item1)
        item1?.setOnClickListener {
            itemClick(it as? GameTypeItem?)
        }
        addView(item1)
    }

    private fun createItem2() {
        item2 = GameTypeItem(context)
        val params = LayoutParams(100.dp, 134.dp)
        item2?.setPadding(16.dp, 16.dp, 16.dp, 16.dp)
        item2?.layoutParams = params
        item2?.text = "with Internet"
        item2?.setImageResource(R.drawable.ic_network_svgrepo_com__1_)
        items.add(item2)
        item2?.setOnClickListener {
            itemClick(it as? GameTypeItem?)
        }
        addView(item2)
    }

    private fun createItem3() {
        item3 = GameTypeItem(context)
        val params = LayoutParams(100.dp, 134.dp)
        item3?.setPadding(16.dp, 16.dp, 16.dp, 16.dp)
        item3?.layoutParams = params
        item3?.text = "Player 2"
        item3?.setImageResource(R.drawable.ic_two_persons_svgrepo_com)
        items.add(item3)
        item3?.setOnClickListener {
            itemClick(it as? GameTypeItem?)
        }
        addView(item3)
    }


    private fun itemClick(item: GameTypeItem?) {
        for (temp in items) {
            temp?.isChecked = item == temp
        }
    }
}