package com.example.comes.network.model

import androidx.lifecycle.ViewModel
import com.example.comes.network.model.request.LoginRequest
import com.example.comes.network.model.response.LoginResponse
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import retrofit2.Call

open class BaseViewModel : ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

//    fun reqLogin(model: LoginRequest?): Call<LoginResponse?>? {
//        return DataRepository.instance?.reqLogin(model)
//    }
}