package com.example.comes.util

import com.google.gson.Gson
import java.lang.reflect.Type
import java.util.HashMap

object ComesUil {
    //영문자 포함 체크 정규식
    const val REGEX_ALPHABET = "[a-zA-Z]"

    //숫자 포함 체크 정규식
    const val REGEX_NUMERIC = "[0-9]"

    //특수문자 포함 체크 정규식
    const val REGEX_SPECIAL_CHAR = "[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]"
    fun convertObjectToHashMap(`object`: Any?): HashMap<String, Any> {
        var map = HashMap<String, Any>()
        val gson = Gson()
        try {
            val mapClass: Class<*> = map.javaClass
            map = gson.fromJson(gson.toJson(`object`), mapClass as Type)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        for (key in map.keys) {
            LogUtil.e("Key : " + key + "  value : " + map[key].toString())
        }
        return map
    }
}
