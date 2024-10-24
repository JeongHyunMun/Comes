package com.example.comes.util

import android.content.Context
import android.content.SharedPreferences
import com.example.comes.common.DEFINE
import com.example.comes.common.PrefDefine

class PreferenceUtil {

    private val PreferenceFile: MutableMap<String, SharedPreferences> = mutableMapOf()

    var prefDefine: DEFINE = PrefDefine()

    fun getPreferences(filename: String): SharedPreferences? {

        val preferences = PreferenceFile[filename]
        if (preferences == null) {
            //PreferenceFile.put(filename, RmsApp.getContext().getSharedPreferences(filename, Context.MODE_PRIVATE))
        }

        return PreferenceFile[filename]
    }

    fun getString(context: Context, key: String): String? {
        return getPreferences(prefDefine.toString())?.getString(key, "")
    }

}