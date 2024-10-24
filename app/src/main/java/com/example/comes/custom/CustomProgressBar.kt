package com.example.comes.custom

import android.content.Context
import android.util.AttributeSet
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.appcompat.widget.AppCompatImageView
import com.example.comes.R

/**
 * ProgressBar 애니메이션.
 */
class CustomProgressBar : AppCompatImageView {
    var rotateAnimation: RotateAnimation? = null
        private set

    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!, attrs, defStyle
    ) {
        init()
    }

    private fun init() {
        setImageResource(R.drawable.loadingbar)
        rotateAnimation = RotateAnimation(
            353f, 0f, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation!!.interpolator = LinearInterpolator()
        rotateAnimation!!.repeatCount = Animation.INFINITE
        rotateAnimation!!.duration = 1000
        startAnimation(rotateAnimation)
    }
}