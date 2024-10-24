package com.example.comes.network.model.request

import com.google.gson.annotations.SerializedName

class LoginRequest {

    @SerializedName("autoLogin")
    private var autoLgn: String? = null

    @SerializedName("username")
    private var lgnId: String? = null

    @SerializedName("password")
    private var lgnPwd: String? = null

    @SerializedName("locale")
    private var locale: String? = null

    @SerializedName("pushToken")
    private var pushToken: String? = null
    fun setAutoLgn(autoLgn: String?) {
        this.autoLgn = autoLgn
    }

    fun setLgnId(lgnId: String?) {
        this.lgnId = lgnId
    }

    fun setLgnPwd(lgnPwd: String?) {
        this.lgnPwd = lgnPwd
    }

    fun setLocale(locale: String?) {
        this.locale = locale
    }

    fun setPushToken(pushToken: String?) {
        this.pushToken = pushToken
    }

}