package com.example.comes.network.model.response

import com.google.gson.annotations.SerializedName

/**
 * 버전정보 Response Model
 */
class AppVersionResponse : BaseResponse() {

    @SerializedName("versions")
    var versions = ArrayList<VersionItem>()

    inner class VersionItem {
        @SerializedName("type")
        val type: String? = null

        @SerializedName("ver")
        val ver: String? = null
        override fun toString(): String {
            val sb = StringBuilder("VersionItem{")
            sb.append("type='").append(type).append('\'')
            sb.append(", ver='").append(ver).append('\'')
            sb.append('}')
            return sb.toString()
        }
    }

}