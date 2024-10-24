package com.example.comes.network.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Observable

/**
 * 비동기적으로 데이터를 처리하는 기능
 *
 */
class MainViewModel : BaseViewModel() {

    // LiveData를 통해 데이터 상태 관리
    private val _data = MutableLiveData<String>()
    val data: LiveData<String> get() = _data


    fun getData() {
        val disposable = someObservableFunction()
            .subscribe(
                { result ->
                    // 성공적으로 데이터 처리
                },
                { error ->
                    // 에러 처리
                }
            )
        addDisposable(disposable)
    }

    init {

    }

    // 예시로 Observable을 반환하는 함수
    private fun someObservableFunction(): Observable<String> {
        return Observable.just("Some Data")
    }
}