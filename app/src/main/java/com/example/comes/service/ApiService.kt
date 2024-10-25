package com.example.comes.service

import com.example.comes.network.model.request.LoginRequest
import com.example.comes.network.model.response.AppVersionResponse
import com.example.comes.network.model.response.BaseResponse
import com.example.comes.network.model.response.FindIdResponse
import com.example.comes.network.model.response.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    // 앱버전 조회
    @GET("misc/versions")
    fun getAppVersion(@Query("locale") locale: String?): Call<AppVersionResponse?>?

    // 로그인
    @FormUrlEncoded
    @POST("login")
    fun reqLogin(@FieldMap map: java.util.HashMap<String, Any>): Call<LoginResponse?>?

    // 최초 비밀번호 변경
    @FormUrlEncoded
    @POST("user/password")
    fun reqInitPassword(@FieldMap map: HashMap<String?, Any?>?): Call<BaseResponse?>?

    // 비밀번호 변경 (다음에 변경하기)
    @POST("user/password/next")
    fun reqChangeNext(@Query("_method") _method: String?): Call<BaseResponse?>?

    // 비밀번호 변경
    @FormUrlEncoded
    @POST("user/password")
    fun reqChangePassword(@FieldMap map: HashMap<String?, Any?>?): Call<BaseResponse?>?

    // 아이디 찾기
    @FormUrlEncoded
    @POST("user/find/id")
    fun reqFindId(@FieldMap map: HashMap<String?, Any?>?): Call<FindIdResponse?>?

    // 비밀번호 찾기
    @FormUrlEncoded
    @POST("user/find/password")
    fun reqFindPassword(@FieldMap map: HashMap<String?, Any?>?): Call<BaseResponse?>?

    // 언어변경
    @FormUrlEncoded
    @POST("user/language")
    fun reqLocale(@FieldMap map: HashMap<String?, Any?>?): Call<BaseResponse?>?

    // 로그아웃
    @FormUrlEncoded
    @POST("logout")
    fun reqLogout(): Call<BaseResponse?>?
}