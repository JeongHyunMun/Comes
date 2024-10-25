package com.example.comes.repository

import androidx.lifecycle.MutableLiveData
import com.example.comes.network.model.request.LoginRequest
import com.example.comes.network.model.response.LoginResponse
import com.example.comes.service.ApiService
import com.example.comes.util.ComesUil
import retrofit2.Call

class DataRepository {
    private val mApiService: ApiService = TODO()
    private val mMultipartApiService: ApiService
    var isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    /**
     * 로그인
     */
    fun reqLogin(loginRequest: LoginRequest?): Call<LoginResponse?>? {
        return mApiService.reqLogin(ComesUil.convertObjectToHashMap(loginRequest))
    }

    companion object {
        private var mInstance: DataRepository? = null
        @JvmStatic
        val instance: DataRepository?
            get() {
                if (mInstance == null) {
                    mInstance = DataRepository()
                }
                return mInstance
            }
    }
}