package com.example.comes.view.main

import android.os.Bundle
import com.example.comes.R
import com.example.comes.databinding.ActivityMainBinding
import com.example.comes.network.model.MainViewModel
import com.example.comes.view.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView는 이미 BaseActivity에서 처리되므로 추가로 호출할 필요 없음
        initView()
        initDataBinding()
        initAfterBinding()
    }

    override fun initView() {
        // UI 초기화 관련 코드를 여기에 작성
    }

    override fun initDataBinding() {
        // DataBinding 관련 초기화 작업 작성
    }

    override fun initAfterBinding() {
        // DataBinding 이후 작업 작성
    }

}