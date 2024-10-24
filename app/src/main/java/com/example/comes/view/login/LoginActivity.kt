package com.example.comes.view.login

import android.app.Activity
import android.os.Bundle
import com.example.comes.R
import com.example.comes.databinding.ActivityLoginBinding
import com.example.comes.databinding.ActivityMainBinding
import com.example.comes.network.model.BaseViewModel
import com.example.comes.network.model.MainViewModel
import com.example.comes.view.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding, MainViewModel>() {
    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    override fun initView() {
        // UI 초기화 관련 코드를 여기에 작성
        var lgn_id = binding.loginId
        var lgn_pw = binding.loginPw
        var lgn_btn = binding.loginBtn
    }

    override fun initDataBinding() {
        // DataBinding 관련 초기화 작업 작성
    }

    override fun initAfterBinding() {
        // DataBinding 이후 작업 작성
    }
}