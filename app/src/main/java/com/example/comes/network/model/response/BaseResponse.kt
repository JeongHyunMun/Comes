package com.example.comes.network.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serial
import java.io.Serializable

open class BaseResponse : Serializable {
    @SerializedName("result")
    var result: Result? = null

    inner class Result {
        @SerializedName("code")
        var code: String? = null

        @SerializedName("message")
        var message: String? = null

        @SerializedName("externalError")
        var externalError: ExternalError? = null
        override fun toString(): String {
            val sb = StringBuilder("Result{")
            sb.append("code='").append(code).append('\'')
            sb.append(", message='").append(message).append('\'')
            sb.append('}')
            return sb.toString()
        }
    }

    inner class ExternalError {
        @SerializedName("system")
        var system: String? = null

        @SerializedName("code")
        var code: String? = null

        @SerializedName("message")
        var message: String? = null
        override fun toString(): String {
            var sb = java.lang.StringBuilder("ExternalError{")
            sb.append("system='").append(system).append('\'')
            sb.append(", code='").append(code).append('\'')
            sb.append(", message='").append(message).append('\'')
            sb.append('}')

            return sb.toString()
        }
    }

    /**
     * 응답 성공 여부
     * @param success
     */
    var isSuccess = false

    /**
     * 오류 팝업 메시지 노출 여부
     * @param localPopup
     */
    var isLocalPopup = false
}