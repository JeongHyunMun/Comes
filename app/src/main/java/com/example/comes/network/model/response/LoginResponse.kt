package com.example.comes.network.model.response

import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("user")
    val user: User? = null

    @SerializedName("roles")
    var roles: ArrayList<String>? = null

    inner class User {
        @SerializedName("userNo")
        var userNo: String? = null

        // 이름
        @SerializedName("userFirstName") // 이름
        var userFirstName: String? = null

        // 성
        @SerializedName("userLastName") // 성
        var userLastName: String? = null

        @SerializedName("language")
        var language: String? = null

        @SerializedName("token")
        val token: String? = null

        @SerializedName("passwordInitYn")
        var passwordInitYn: Boolean? = null

        @SerializedName("passwordExpiredYn")
        val passwordExpiredYn: Boolean? = null

        @SerializedName("passwordExpirationPeriod")
        val passwordExpirationPeriod: String? = null

        @SerializedName("agreeTermsYn")
        val agreeTermsYn: Boolean? = null
        override fun toString(): String {
            val sb = StringBuilder("Member{")
            sb.append("userNo='").append(userNo).append('\'')
            sb.append(", language='").append(language).append('\'')
            sb.append(", passwordInitYn='").append(passwordInitYn).append('\'')
            sb.append('}')
            return sb.toString()
        }
    }
}