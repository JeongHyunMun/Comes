package com.example.comes.network.model.response

import com.google.gson.annotations.SerializedName

class FindIdResponse : BaseResponse() {

    @JvmField
    @SerializedName("ids")
    var ids: ArrayList<String>? = null
}