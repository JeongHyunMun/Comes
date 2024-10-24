package com.example.comes.util

import android.app.Activity
import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.TypedValue
import androidx.core.content.ContextCompat
import com.example.comes.ComesApp

object ResourceUtil {
    fun getColor(id: Int): Int {
        return ContextCompat.getColor(ComesApp.instance, id)
    }

    @JvmStatic
    fun getDrawable(id: Int): Drawable? {
        return ContextCompat.getDrawable(ComesApp.instance, id)
    }

    /**
     * 해당 DP를 pX로 변환하여 반환
     *
     * @param dp
     * @return int
     */
    @JvmStatic
    fun getPxFromDp(activity: Activity, dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            activity.resources.displayMetrics
        ).toInt()
    }
}