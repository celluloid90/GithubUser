package com.bitflyer.test.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import com.bitflyer.test.R
import com.bitflyer.test.logger.AlLog

class AmTextView : android.support.v7.widget.AppCompatTextView {

    private var mFont: String = "R"
    private var mPath: String = "fonts/Ubuntu-"
    private var mType: String = ".ttf"

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setValues(attrs)
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        setFont(mFont)
        setNewTypeFace()
    }

    fun setFont(font: String) {
        mFont = font
    }

    fun getFont(): String {
        return mFont
    }

    private fun setNewTypeFace() {
        val font = Typeface.createFromAsset(context.assets, mPath + mFont + mType)
        setTypeface(font, Typeface.NORMAL)
    }

    private fun setValues(attrs: AttributeSet?) {
        val attr = context.obtainStyledAttributes(attrs, R.styleable.AmTextView)
        try {
            val n = attr.indexCount
            for (i in 0 until n) {
                val attribute = attr.getIndex(i)
                when (attribute) {
                    R.styleable.AmTextView_Amfont -> mFont = attr.getString(attribute).toString()
                    else -> AlLog.d("Unknown attribute for " + javaClass.toString() + ": " + attribute)
                }
            }
        } finally {
            attr.recycle()
        }
    }

}

