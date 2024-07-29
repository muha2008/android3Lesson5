package com.example.android3lesson5.ui.adapter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Region
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class TriangleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas) {
        val path = Path().apply {
            moveTo(0f, height.toFloat())
            lineTo((width / 2).toFloat(), 0f)
            lineTo(width.toFloat(), height.toFloat())
            close()
        }

        canvas.clipPath(path, Region.Op.INTERSECT)
        super.onDraw(canvas)
    }
}
