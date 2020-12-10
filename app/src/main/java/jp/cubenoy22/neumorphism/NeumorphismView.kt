package jp.cubenoy22.neumorphism

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

class NeumorphismView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @ColorInt
    var bgColor = 0xFFEFEEEE.toInt()
        set(value) {
            field = value
            invalidate()
        }

    @ColorInt
    var fillColor = 0xFFEFEEEE.toInt()
        set(value) {
            field = value
            invalidate()
        }

    var size = 0
        set(value) {
            field = value
            updateRect()
        }

    var shadowOffset = 6
        set(value) {
            field = value
            updateLightShadow()
            updateDarkShadow()
        }

    var roundCornerRadius = 40
        set(value) {
            field = value
            invalidate()
        }

    var shadowRadius = 16
        set(value) {
            field = value
            updateLightShadow()
            updateDarkShadow()
        }

    @ColorInt
    var lightShadowColor = 0x7F_FFFFFF
        set(value) {
            field = value
            updateLightShadow()
        }

    @ColorInt
    var darkShadowColor = 0x7F_D1CDC7
        set(value) {
            field = value
            updateDarkShadow()
        }

    @ColorInt
    var borderColor = 0x33_FFFFFF
        set(value) {
            field = value
            updateBorder()
        }

    private val backgroundPaint = Paint().apply {
        color = bgColor
    }
    private val lightShadowPaint = Paint().apply {
        color = fillColor
    }

    private val darkShadowPaint = Paint().apply {
        color = fillColor
    }

    private val borderPaint = Paint().apply {
        style = Paint.Style.STROKE
        color = borderColor
        strokeWidth = resources.displayMetrics.density
    }

    private val rect = RectF()

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.NeumorphismView, defStyleAttr, 0).apply {
            shadowOffset = getInt(R.styleable.NeumorphismView_shadowOffset, shadowOffset)
            roundCornerRadius = getInt(R.styleable.NeumorphismView_roundCornerRadius, roundCornerRadius)
            shadowRadius = getInt(R.styleable.NeumorphismView_shadowRadius, shadowRadius)
        }
        updateLightShadow()
        updateDarkShadow()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        updateRect()
    }

    private fun updateRect() {
        val adjustedSize = if (size > 0) size else width / 2
        val scale = (adjustedSize / 4 - shadowOffset * 2) * resources.displayMetrics.density
        rect.left = width / 2 - scale
        rect.top = height / 2 - scale
        rect.right = width / 2 + scale
        rect.bottom = height / 2 + scale
        invalidate()
    }

    private fun updateLightShadow() {
        lightShadowPaint.color = fillColor
        lightShadowPaint.setShadowLayer(shadowRadius + 0f, 0f - shadowOffset, 0f - shadowOffset, lightShadowColor)
        invalidate()
    }

    private fun updateDarkShadow() {
        darkShadowPaint.color = fillColor
        darkShadowPaint.setShadowLayer(shadowRadius + 0f, shadowOffset + 0f, shadowOffset + 0f, darkShadowColor)
        invalidate()
    }

    private fun updateBorder() {
        borderPaint.color = borderColor
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas ?: return
        canvas.drawRect(0f, 0f, width + 0f, height + 0f, backgroundPaint)
        val cornerRadius = roundCornerRadius + 0f
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, lightShadowPaint)
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, darkShadowPaint)
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, borderPaint)
    }
}